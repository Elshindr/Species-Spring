package org.elshindr.Species_REST.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * EntityToCreateHasAnIdException
 * Réécriture du message pour l'exception http bad request
 * Déclencher à la création lorsqu'une propriété id est présente dans le json
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityToCreateHasAnIdException extends RuntimeException {

    public EntityToCreateHasAnIdException(){
        super("Requete mal formée. Id non supporté.");
    }
}
