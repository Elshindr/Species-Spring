package org.elshindr.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.elshindr.enums.Sex;

import java.util.List;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    @NotBlank
    @Size(max = 50)
    private String color;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(length = 50)
    @NotBlank
    @Size(max = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "species_id")
    private Species species;

    @ManyToMany(mappedBy="lstAnimals")
    private List<Person> lstPersons;


    public Animal() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", specie=" + species +
                "}\n";
    }
}
