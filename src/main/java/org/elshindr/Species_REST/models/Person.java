package org.elshindr.Species_REST.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Person
 * Modele pour la classe Person
 */
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Min(1)
    @Max(90)
    private Integer age;

    @Column(length = 50)
    @NotBlank // ni null, ni vide, ni espace vide
    @Size(max = 50)
    private String firstname;

    @Column(length = 50)
    @NotBlank
    @Size(max = 50)
    private String lastname;

    @ManyToMany
    @JoinTable(
            name = "person_animals",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "animals_id"))
    private List<Animal> lstAnimals = new ArrayList<>();

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Animal> getLstAnimals() {
        return lstAnimals;
    }

    public void setLstAnimals(List<Animal> lstAnimals) {
        this.lstAnimals = lstAnimals;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                "}\n";
    }
}
