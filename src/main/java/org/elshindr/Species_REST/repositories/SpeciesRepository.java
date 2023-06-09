package org.elshindr.Species_REST.repositories;


import org.elshindr.Species_REST.models.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * SpeciesRepository
 * Interface des méthodes de recherches sur la classe Species
 */
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    List<Species> findFirstByCommonNameContains(String commonName);

    List<Species> findByLatinNameContainsIgnoreCase(String latinName);

    List<Species> findDistinctById(Integer id);

    @Query("FROM Species ORDER BY commonName ASC")
    List<Species> findAllSpeciesOrderByCommonASC();

    @Query("FROM Species WHERE commonName LIKE %:commonName% ORDER BY commonName ASC")
    List<Species> findAllSpeciesLikeCommonName(String commonName);
}
