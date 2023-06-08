package org.elshindr.controlers;

import jakarta.validation.Valid;
import org.elshindr.models.Species;
import org.elshindr.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/species")
public class SpeciesController {


    @Autowired
    private SpeciesService speciesSrv;


    @GetMapping
    public List<Species> getAll(){
        return speciesSrv.getAll();
    }


    @GetMapping("pageable")
    public Page<Species> getAll(@RequestParam(value="pageSize", required = false, defaultValue = "2") Integer pageSize,
                                @RequestParam(value="pageNumber", required = false, defaultValue = "0")Integer pageNumber){
        return speciesSrv.getAll(PageRequest.of(pageNumber, pageSize));
    }


    @GetMapping("{id}")
    public Species getOne(@PathVariable Integer id){
        return speciesSrv.getOne(id);
    }


    @PostMapping
    public Species create(@RequestBody @Valid Species species){
        return speciesSrv.create(species);
    }


    @PutMapping
    public Species update(@RequestBody @Valid Species species){
        return speciesSrv.update(species);
    }


    @DeleteMapping("{id}")
    public void delete(@RequestBody @Valid Species species){
        speciesSrv.delete(species);
    }
}
