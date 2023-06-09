package org.elshindr.Species_REST.services;

import jakarta.validation.Valid;
import org.elshindr.Species_REST.exceptions.EntityNotFoundException;
import org.elshindr.Species_REST.exceptions.EntityToCreateHasAnIdException;
import org.elshindr.Species_REST.exceptions.EntityToUpdateHasNoIdException;
import org.elshindr.Species_REST.models.Species;
import org.elshindr.Species_REST.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * SpeciesService
 * Traitement des données de la classe Animal envoyées par SpeciesService
 */
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
