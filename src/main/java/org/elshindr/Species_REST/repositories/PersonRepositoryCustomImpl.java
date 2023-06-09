package org.elshindr.Species_REST.repositories;


import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.elshindr.Species_REST.models.Person;

import java.util.List;

/**
 * PersonRepository
 * Classe de définition des méthodes customs de recherches sur la classe Person
 */
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {


   @PersistenceContext
    private EntityManager em;

    @Override
    public void deletePersonWithoutPet() {

        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.lstAnimals IS EMPTY", Person.class);
        List<Person> lstPersonToDelete = query.getResultList();

        /*
        String sql = "SELECT * FROM person WHERE NOT EXISTS (" +
                        " SELECT 1 FROM person_animals WHERE person_animals.person_id = person.id" +
                    ")";
        List lstPersonToDelete = em.createNativeQuery(sql, Person.class).getResultList();
        */

        if(lstPersonToDelete != null){
            lstPersonToDelete.forEach(p -> em.remove(p));
        }
    }

    @Override
    public void createPerson(Integer nbPerson) {

        Faker faker = new Faker();

        for(int i = 0; i<nbPerson; i++){
            Person guy = new Person();
            guy.setAge(faker.number().numberBetween(10,70));
            guy.setLastname(faker.name().lastName());
            guy.setFirstname(faker.name().firstName());
            em.persist(guy);
        }
    }
}
