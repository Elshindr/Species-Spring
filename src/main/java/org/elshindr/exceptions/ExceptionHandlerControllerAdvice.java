package org.elshindr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {
  /*  @ExceptionHandler({jakarta.persistence.EntityNotFoundException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDto handleExceptionNotFound(Exception exception, WebRequest request){
        exception.printStackTrace();
        return new

    }*/
}
