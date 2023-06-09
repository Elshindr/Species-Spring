package org.elshindr.Species_REST.controllers;

import jakarta.validation.Valid;
import org.elshindr.Species_REST.models.Animal;
import org.elshindr.Species_REST.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * AnimalController
 * Execution des méthodes https liées à la classe Animal
 */
@RestController
@RequestMapping("/rest/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalSrv;


    @GetMapping
    public List<Animal> getAll(){
        return animalSrv.getAll();
    }


    @GetMapping("pageable")
    public Page<Animal> getAll(@RequestParam(value= "pageSize", required=false, defaultValue = "2") Integer pageSize,
                               @RequestParam(value= "pageNumber", required=false, defaultValue = "0") Integer pageNumber){
        return animalSrv.getAll(PageRequest.of(pageNumber, pageSize));
    }


    @GetMapping("{id}")
    public Animal getOne(@PathVariable Integer id){
        return animalSrv.getOne(id);
    }


    @PostMapping
    public Animal create(@RequestBody @Valid Animal animal){
        return animalSrv.create(animal);
    }


    @PutMapping
    public Animal update(@RequestBody @Valid Animal animal){
        return animalSrv.update(animal);
    }


    @DeleteMapping("{id}")
    public void delete(@RequestBody @Valid Animal animal){
        animalSrv.delete(animal);
    }

}
