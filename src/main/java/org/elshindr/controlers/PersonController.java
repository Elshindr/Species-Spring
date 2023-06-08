package org.elshindr.controlers;

import com.github.javafaker.Faker;
import jakarta.validation.Valid;
import org.elshindr.models.Person;
import org.elshindr.repositories.AnimalRepository;
import org.elshindr.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private AnimalRepository animalRepo;


    @GetMapping("person")
    public String getLstPerson(Model model){
        List<Person> lstPersons = this.personRepo.findAll();
        model.addAttribute("personList", lstPersons);

        return "person/list_person";
    }


    @GetMapping("person/{id}")
    public String getDetailPerson(@PathVariable("id") Integer id, Model model){
        Optional<Person> optionalPerson = personRepo.findById(id);

        if(optionalPerson.isEmpty()){
            return  "error";
        }

        model.addAttribute("person", optionalPerson);
        model.addAttribute(
                "animalList",
                animalRepo.findAnimalByPerson(optionalPerson.get().getId())
        );

        return "person/detail_person";
    }


    @GetMapping("person/create")
    public String getCreatePerson(Model model){
        model.addAttribute("person", new Person());
        model.addAttribute("animalList", animalRepo.findAll());

        return "person/create_person";
    }

    @PostMapping("person/create/random")
    public String createRandom(Model model){
        Faker faker = new Faker();
        Person person = new Person();
        person.setFirstname(faker.name().firstName());
        person.setLastname(faker.name().lastName());
        person.setAge(faker.number().numberBetween(12, 90));

        this.personRepo.save(person);

        return "redirect:/person";
    }

    // CRUD
    @PostMapping("person")
    public String createOrUpdate(@Valid Person personItem, BindingResult bindingR, Model model){

        if (bindingR.hasErrors()) {
            model.addAttribute("animalList", animalRepo.findAll());
            if (personItem.getId() != null) {
                return "person/detail_person";
            }
            return "person/create_person";
        }

        personRepo.save(personItem);
        return "redirect:/person";
    }


    @GetMapping("person/delete/{id}")
    public String deletePerson(@PathVariable("id") Integer id){
        this.personRepo.deleteById(id);

        return "redirect:/person";
    }

}
