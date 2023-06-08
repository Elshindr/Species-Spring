package org.elshindr.controlers;

import jakarta.validation.Valid;
import org.elshindr.models.Animal;
import org.elshindr.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalSrv;


    @GetMapping
    public List<Animal> getAll(){
        return animalSrv.getAll();
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
