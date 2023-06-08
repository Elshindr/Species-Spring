package org.elshindr.controlers;

import jakarta.validation.Valid;
import org.elshindr.enums.Sex;
import org.elshindr.models.Animal;
import org.elshindr.models.Person;
import org.elshindr.repositories.AnimalRepository;
import org.elshindr.repositories.PersonRepository;
import org.elshindr.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("animal")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepo;

    @Autowired
    private SpeciesRepository speciesRepo;

    @Autowired
    private PersonRepository personRepo;


    // VIEWS - READ
    @GetMapping
    public String getLstAnimal(Model model){
        List<Animal> lstAnimals = this.animalRepo.findAll();
        model.addAttribute("animalList", lstAnimals);

        return "animal/list_animal";
    }


    @GetMapping("/{id}")
    public String getDetailAnimal(@PathVariable("id") Integer id, Model model){
        Optional<Animal> optionalAnimal = animalRepo.findById(id);

        if(optionalAnimal.isEmpty()){
            return  "error";
        }
        model.addAttribute("animal", optionalAnimal);
        model.addAttribute("speciesList", speciesRepo.findAll(Sort.by(Sort.Direction.ASC, "commonName")));

        return "animal/detail_animal";
    }


    //CUD
    @GetMapping("/create")
    public String getCreateAnimal(Model model){
        model.addAttribute("animal", new Animal() );
        model.addAttribute(
                "speciesList",
                speciesRepo.findAll(Sort.by(Sort.Direction.ASC, "commonName"))
        );
        model.addAttribute("sexList", Sex.values());

        return "animal/create_animal";
    }


   @PostMapping
    public String createOrUpdate(@Valid Animal animalItem, BindingResult bindingR, Model model){

        if(bindingR.hasErrors()){
            if(animalItem.getId() != null){
                model.addAttribute(
                        "speciesList",
                        speciesRepo.findAll(Sort.by(Sort.Direction.ASC, "commonName"))
                );
                model.addAttribute("sexList", Sex.values());
                return "animal/detail_animal";
            }

            model.addAttribute(
                    "speciesList",
                    speciesRepo.findAll(Sort.by(Sort.Direction.ASC, "commonName"))
            );
            model.addAttribute("sexList", Sex.values());
            return "animal/create_animal";
        }

        this.animalRepo.save(animalItem);

        return "redirect:animal";
    }


    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable("id") Integer id){

        if(this.personRepo.findPersonByAnimal(id) != null){
           List<Person> lstPerson = this.personRepo.findPersonByAnimal(id);

           lstPerson.forEach(guy -> {
               guy.getLstAnimals().remove(this.animalRepo.getReferenceById(id));
               this.personRepo.save(guy);
           });
        }
        this.animalRepo.deleteById(id);

        return "redirect:/animal";
    }

}
