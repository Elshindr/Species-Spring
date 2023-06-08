package org.elshindr.services;

import jakarta.validation.Valid;
import org.elshindr.exceptions.EntityNotFoundException;
import org.elshindr.exceptions.EntityToCreateHasAnIdException;
import org.elshindr.exceptions.EntityToUpdateHasNoIdException;
import org.elshindr.models.Species;
import org.elshindr.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepo;


    public List<Species> getAll(){
        return speciesRepo.findAll();
    }

    public Page<Species> getAll(Pageable pageable){
        return speciesRepo.findAll(pageable);
    }

    public Species getOne(Integer id){
        return speciesRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Species create(@Valid Species species){
        if(species.getId() != null){
            throw new EntityToCreateHasAnIdException();
        }
        return speciesRepo.save(species);
    }

    public Species update(@Valid Species species){
        if(species.getId() == null){
            throw new EntityToUpdateHasNoIdException();
        }
        return speciesRepo.save(species);
    }

    public void delete(@Valid Species species){
        speciesRepo.delete(species);
    }
}
