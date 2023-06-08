package org.elshindr.services;

import jakarta.persistence.EntityExistsException;
import jakarta.validation.Valid;
import org.elshindr.exceptions.EntityNotFoundException;
import org.elshindr.exceptions.EntityToCreateHasAnIdException;
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

    // PAGES
    public Page<Person> getAll(Pageable pageable){
        return personRepo.findAll(pageable);
    }

    // CRUD REST
    public Person getOne(Integer id){ return personRepo.findById(id).orElseThrow(EntityNotFoundException::new);}

    public List<Person> getAll(){
        return personRepo.findAll();
    }

    public Person create(@Valid Person newPerson){
        if(newPerson.getId() != null){
            throw new EntityToCreateHasAnIdException();
        }

        return personRepo.save(newPerson);
    }

    public Person update(@Valid Person updPerson){
        return personRepo.save(updPerson);
    }

    public void delete(@Valid Person updPerson){
        personRepo.delete(updPerson);
    }
}
