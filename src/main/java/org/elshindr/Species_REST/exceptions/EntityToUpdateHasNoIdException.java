package org.elshindr.Species_REST.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * EntityToUpdateHasNoIdException
 * Réécriture du message pour l'exception http bad request
 * Déclencher à l'update lorsqu'une propriété id est absente dans le json
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityToUpdateHasNoIdException extends RuntimeException{
    public EntityToUpdateHasNoIdException(){
        super("Requete mal formée. Id absent.");
    }
}
