package org.elshindr.Species_REST.controllers;


import jakarta.validation.Valid;
import org.elshindr.Species_REST.dtos.PersonDto;
import org.elshindr.Species_REST.models.Person;
import org.elshindr.Species_REST.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PersonController
 * Execution des méthodes https liées à la classe Person
 */
@RestController
@RequestMapping("/rest/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("pageable")
    public Page<PersonDto> getAll(@RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize,
                               @RequestParam(value = "pageNumber", required = false, defaultValue ="5") Integer pageNumber){

        return personService.getAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping
    public List<Person> getAll(){
        return personService.getAll();
    }


    @GetMapping("{id}")
    public Person getOne(@PathVariable Integer id){
      return personService.getOne(id);
    }


    @PostMapping
    public Person create(@RequestBody @Valid Person newPerson){
        return personService.create(newPerson);
    }

    @PutMapping
    public Person update(@RequestBody @Valid Person updPerson){
        return this.personService.update(updPerson);
    }


    @DeleteMapping("{id}")
    public void delete(@RequestBody @Valid Person dltPerson){
        this.personService.delete(dltPerson);
    }
}
