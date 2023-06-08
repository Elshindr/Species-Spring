package org.elshindr.dtos.mappers;

import org.elshindr.dtos.dtos.PersonDto;
import org.elshindr.models.Animal;
import org.elshindr.models.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonDtoMapper {

    public PersonDto toDto(Person person){
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId().toString());
        personDto.setNomAge(person.getLastname() + " " + person.getFirstname() + " " + person.getAge());


        String[] arrAnimaux = new String[person.getLstAnimals().size()];
        for (int i = 0; i < person.getLstAnimals().size(); i++) {
            Animal pet = person.getLstAnimals().get(i);
            arrAnimaux[i]= pet.getName() + " (" + pet.getSpecies().getCommonName()+")";
        }
        personDto.setAnimaux(arrAnimaux);
        return personDto;
    }
}
