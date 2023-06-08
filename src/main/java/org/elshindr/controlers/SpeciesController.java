package org.elshindr.controlers;

import jakarta.validation.Valid;
import org.elshindr.models.Animal;
import org.elshindr.models.Species;
import org.elshindr.repositories.SpeciesRepository;
import org.elshindr.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/species")
public class SpeciesController {


    @Autowired
    private SpeciesService speciesSrv;

    @GetMapping
    public List<Species> getAll(){
        return speciesSrv.getAll();
    }

    @GetMapping("{id}")
    public Species getOne(@PathVariable Integer id){
        return speciesSrv.getOne(id);
    }

    @PostMapping
    public Species create(@RequestBody @Valid Species species){
        return speciesSrv.create(species);
    }

    @PutMapping
    public Species update(@RequestBody @Valid Species species){
        return speciesSrv.update(species);
    }

    @DeleteMapping("{id}")
    public void delete(@RequestBody @Valid Species species){
        speciesSrv.delete(species);
    }
}
