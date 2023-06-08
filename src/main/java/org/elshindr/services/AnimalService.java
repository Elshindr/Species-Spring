package org.elshindr.services;


import jakarta.persistence.EntityExistsException;
import jakarta.validation.Valid;
import org.elshindr.models.Animal;
import org.elshindr.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepo;


    public List<Animal> getAll(){
        return animalRepo.findAll();
    }

    public Animal getOne(Integer id){
        return animalRepo.findById(id).orElseThrow(EntityExistsException::new);
    }

    public Animal create(@Valid Animal animal){
        return animalRepo.save(animal);
    }

    public Animal update(@Valid Animal animal){
        return animalRepo.save(animal);
    }

    public void delete(@Valid Animal animal){
        animalRepo.delete(animal);
    }
}
