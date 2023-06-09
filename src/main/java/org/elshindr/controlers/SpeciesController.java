package org.elshindr.controlers;

import jakarta.validation.Valid;
import org.elshindr.models.Species;
import org.elshindr.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


/**
 * SpeciesController
 * Execution des méthodes https liées à la classe Species
 */
@Controller
public class SpeciesController {

    @Autowired
    private SpeciesRepository speciesRepo;

    // VIEWS
    @GetMapping("species")
    public String getLstSpecies(Model model){

        List<Species> lstSpecies = this.speciesRepo.findAll(Sort.by(Sort.Direction.ASC, "commonName"));

        model.addAttribute("speciesList", lstSpecies);

        return "species/list_species";
    }

    @GetMapping("species/{id}")
    public String getDetailSpecies(@PathVariable("id") Integer id, Model model){
        Optional<Species> optionalSpecies = speciesRepo.findById(id);

        if(optionalSpecies.isEmpty()){
            return  "error";
        }
        model.addAttribute("species", optionalSpecies);

        return "species/detail_species";
    }

    @GetMapping("species/create")
    public String getCreateSpecie(Model model){

        model.addAttribute("species", new Species());

        return "species/create_species";
    }


    // CRUD
    @PostMapping("species")
    public String createOrUpdate(@Valid Species speciesItem, BindingResult bindingR) {

        if(bindingR.hasErrors()){

            if(speciesItem.getId() != null){
                return "species/detail_species";
            }

            return "species/create_species";
        }

        speciesRepo.save(speciesItem);
        return "redirect:/species";
    }


    @GetMapping("species/delete/{id}")
    public String deleteSpecies(@PathVariable("id") Integer id) {

        this.speciesRepo.deleteById(id);

        return "redirect:/species";
    }
}
