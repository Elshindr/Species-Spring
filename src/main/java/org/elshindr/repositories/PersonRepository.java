package org.elshindr.repositories;


import org.elshindr.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Integer>, PersonRepositoryCustom {

    List<Person> findByLastnameContainsOrFirstnameContains(String lastname, String firstname);
    List<Person> findByAgeIsGreaterThanEqual(int age);

    @Query("FROM Person WHERE age BETWEEN :min AND :max")
    List<Person> findPersonWhereAgeBetween(int max, int min);

    @Query("SELECT DISTINCT p FROM Person p" +
            " INNER JOIN p.lstAnimals a WHERE a.id = :animalId")
    List<Person> findPersonByAnimal(@Param("animalId") Integer animalId);

    List<Person>findByLstAnimalsIsEmpty();

}
