package org.elshindr.repositories;

import org.springframework.transaction.annotation.Transactional;

/**
 * PersonRepository
 * Interface custom des méthodes de recherches sur la classe Person
 */
public interface PersonRepositoryCustom  {

   @Transactional
   void deletePersonWithoutPet();

   @Transactional
   void createPerson(Integer i);
}
