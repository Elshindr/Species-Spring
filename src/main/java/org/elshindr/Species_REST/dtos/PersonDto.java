package org.elshindr.Species_REST.dtos;

import org.elshindr.Species_REST.models.Animal;
import org.elshindr.Species_REST.models.Person;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * PersonDto
 * Model de réécriture de la classe Person
 */
@Component
public class PersonDto {

    private Integer id;
    private String nomAge;
    private String[] animaux;

    public PersonDto() {
    }

    public static PersonDto toDto(Person person){
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setNomAge(person.getLastname() + " " + person.getFirstname() + " " + person.getAge());


        String[] arrAnimaux = new String[person.getLstAnimals().size()];
        for (int i = 0; i < person.getLstAnimals().size(); i++) {
            Animal pet = person.getLstAnimals().get(i);
            arrAnimaux[i]= pet.getName() + " (" + pet.getSpecies().getCommonName()+")";
        }
        personDto.setAnimaux(arrAnimaux);

        return personDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomAge() {
        return nomAge;
    }

    public void setNomAge(String nomAge) {
        this.nomAge = nomAge;
    }

    public String[] getAnimaux() {
        return animaux;
    }

    public void setAnimaux(String[] animaux) {
        this.animaux = animaux;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id='" + id + '\'' +
                ", nomAge='" + nomAge + '\'' +
                ", animaux=" + Arrays.toString(animaux) +
                '}';
    }
}
