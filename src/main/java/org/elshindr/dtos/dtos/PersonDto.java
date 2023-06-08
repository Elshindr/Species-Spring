package org.elshindr.dtos.dtos;

import java.util.Arrays;

public class PersonDto {
    private String id;
    private String nomAge;
    String[] animaux;

    public PersonDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
