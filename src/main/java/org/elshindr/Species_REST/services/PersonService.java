package org.elshindr.Species_REST.services;

import jakarta.validation.Valid;
import org.elshindr.Species_REST.dtos.PersonDto;
import org.elshindr.Species_REST.exceptions.EntityNotFoundException;
import org.elshindr.Species_REST.exceptions.EntityToCreateHasAnIdException;
import org.elshindr.Species_REST.exceptions.EntityToUpdateHasNoIdException;
import org.elshindr.Species_REST.models.Person;
import org.elshindr.Species_REST.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PersonService
 * Traitement des données de la classe Animal envoyées par PersonController
 */
@Service
public class PersonService {

    @Autowired
    PersonRepository personRepo;

    @Autowired
    PersonDto personDto;

    public Page<PersonDto> getAll(Pageable pageable){
        Page<Person> pagePersons = personRepo.findAll(pageable);
        return pagePersons.map((person) -> PersonDto.toDto(person));
    }


    public List<Person> getAll(){
        return personRepo.findAll();
    }


    public Person getOne(Integer id){ return personRepo.findById(id).orElseThrow(EntityNotFoundException::new);}


    public Person create(@Valid Person newPerson){

        if (newPerson.getId() != null){
            throw new EntityToCreateHasAnIdException();
        }

        return personRepo.save(null);
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
