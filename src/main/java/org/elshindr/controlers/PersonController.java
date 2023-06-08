package org.elshindr.controlers;


import jakarta.validation.Valid;
import org.elshindr.dtos.dtos.PersonDto;
import org.elshindr.models.Person;
import org.elshindr.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
