package org.elshindr.services;

import jakarta.validation.Valid;
import org.elshindr.dtos.dtos.PersonDto;
import org.elshindr.dtos.mappers.PersonDtoMapper;
import org.elshindr.exceptions.EntityNotFoundException;
import org.elshindr.exceptions.EntityToCreateHasAnIdException;
import org.elshindr.exceptions.EntityToUpdateHasNoIdException;
import org.elshindr.models.Person;
import org.elshindr.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepo;

    @Autowired
    PersonDtoMapper personDtoMapp;

    public Page<PersonDto> getAll(Pageable pageable){
        Page<Person> pagePersons = personRepo.findAll(pageable);
        return pagePersons.map((person) -> personDtoMapp.toDto(person));
    }


    public List<Person> getAll(){
        return personRepo.findAll();
    }


    public Person getOne(Integer id){ return personRepo.findById(id).orElseThrow(EntityNotFoundException::new);}


    public Person create(@Valid Person newPerson){

        if (newPerson.getId() != null){
            throw new EntityToCreateHasAnIdException();
        }

        return personRepo.save(newPerson);
    }


    public Person update(@Valid Person updPerson){
        if(updPerson.getId() == null){
            throw new EntityToUpdateHasNoIdException();
        }
        return personRepo.save(updPerson);
    }


    public void delete(@Valid Person updPerson){
        personRepo.delete(updPerson);
    }


    public void deletedById(Integer id){
        if(!personRepo.existsById(id)){
            throw new EntityNotFoundException();
        }
        personRepo.deleteById(id);
    }
}
