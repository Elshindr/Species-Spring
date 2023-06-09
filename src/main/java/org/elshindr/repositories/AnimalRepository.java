package org.elshindr.repositories;


import org.elshindr.enums.Sex;
import org.elshindr.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * AnimalRepository
 * Interface des méthodes de recherches sur la classe Animal
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findBySpeciesId(Integer speciesId);
    List<Animal> findByColorIsIn(List<String> lstColor);
    List<Animal> findDistinctById(Integer id);

    @Query("SELECT COUNT(a) FROM Animal a WHERE a.sex = :sex")
    Long findCountBySex(@Param("sex") Sex sex);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Person p JOIN p.lstAnimals a WHERE a.id = :id")
    Boolean findIfAnimalHavePerson(@Param("id") Integer id);

    @Query("SELECT DISTINCT a FROM Animal a" +
            " INNER JOIN a.lstPersons p WHERE p.id = :personId")
    List<Animal> findAnimalByPerson(@Param("personId") Integer personId);

}
