package org.elshindr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityToUpdateHasNoIdException extends RuntimeException{
    public EntityToUpdateHasNoIdException(){
        super("Requete mal formée. Id absent.");
    }
}
