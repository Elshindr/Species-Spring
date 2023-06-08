package org.elshindr.repositories;

import org.springframework.transaction.annotation.Transactional;


public interface PersonRepositoryCustom  {

   @Transactional
   void deletePersonWithoutPet();

   @Transactional
   void createPerson(Integer i);
}
