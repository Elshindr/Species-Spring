package org.elshindr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityToCreateHasAnIdException extends RuntimeException {

    public EntityToCreateHasAnIdException(){
        super("Requete non supportée");
    }
}
