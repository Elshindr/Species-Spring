package org.elshindr.exceptions;

import org.elshindr.dtos.dtos.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler({jakarta.persistence.EntityNotFoundException.class,
            EntityToUpdateHasNoIdException.class,
            EntityToCreateHasAnIdException.class,
            EntityNotFoundException.class
    })
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDto handleExceptionNotFound(Exception e, WebRequest webR) {

       // e.printStackTrace();

        return new ErrorDto(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                e.getMessage(),
                webR.getDescription(false)
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDto handleExceptionNotValid(MethodArgumentNotValidException  e, WebRequest webR){
        BindingResult bdResult = e.getBindingResult();

        List<FieldError> fieldErrors = bdResult.getFieldErrors();

       String strErrors = "Erreur de validation :: ";
        for (org.springframework.validation.FieldError fieldError: fieldErrors) {
            strErrors += fieldError.getField() + " " +  fieldError.getDefaultMessage();
        }

        return new ErrorDto(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                  strErrors,
                webR.getDescription(false)
        );
    }
}
