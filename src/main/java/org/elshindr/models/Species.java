package org.elshindr.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="species")
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank // ni null, ni vide, ni espace vide
    @Size(max = 50)
    @Column(name="common_name")
    private String commonName;

    @NotBlank
    @Size(max = 50)
    @Column(name="latin_name", length = 50)
    private String latinName;

    public Species() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String common_name) {
        this.commonName = common_name;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latin_name) {
        this.latinName = latin_name;
    }

    @Override
    public String toString() {
        return "Specie{" +
                "id=" + id +
                ", commonName='" + commonName + '\'' +
                ", latinName='" + latinName + '\'' +
                "}\n";
    }
}
