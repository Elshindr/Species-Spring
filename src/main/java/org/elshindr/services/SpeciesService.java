package org.elshindr.services;

import jakarta.persistence.EntityExistsException;
import jakarta.validation.Valid;
import org.elshindr.models.Animal;
import org.elshindr.models.Species;
import org.elshindr.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesService {
    @Autowired
    private SpeciesRepository speciesRepo;

    public List<Species> getAll(){
        return speciesRepo.findAll();
    }

    public Species getOne(Integer id){
        return speciesRepo.findById(id).orElseThrow(EntityExistsException::new);

    }

    public Species create(@Valid Species species){
        return speciesRepo.save(species);
    }

    public Species update(@Valid Species species){
        return speciesRepo.save(species);
    }

    public void delete(@Valid Species species){
        speciesRepo.delete(species);
    }
}
