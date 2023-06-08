package org.elshindr.services;


import jakarta.validation.Valid;
import org.elshindr.exceptions.EntityNotFoundException;
import org.elshindr.exceptions.EntityToCreateHasAnIdException;
import org.elshindr.exceptions.EntityToUpdateHasNoIdException;
import org.elshindr.models.Animal;
import org.elshindr.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepo;

    public List<Animal> getAll(){
        return animalRepo.findAll();
    }

    public Page<Animal> getAll(Pageable pageable){
        return animalRepo.findAll(pageable);
    }

    public Animal getOne(Integer id){
        return animalRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Animal create(@Valid Animal animal){
        if(animal.getId() != null){
            throw new EntityToCreateHasAnIdException();
        }
        return animalRepo.save(animal);
    }

    public Animal update(@Valid Animal animal){
        if(animal.getId() == null){
            throw new EntityToUpdateHasNoIdException();
        }
        return animalRepo.save(animal);
    }

    public void delete(@Valid Animal animal){
        animalRepo.delete(animal);
    }
}
