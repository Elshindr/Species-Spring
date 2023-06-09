package org.elshindr.Species_REST.dtos;

import java.time.LocalDateTime;

/**
 * ErrorDto
 * Model de réécriture des exceptions lancés par ExceptionHandlerControllerAdvice
 */
public class ErrorDto {

    private final int statusCode;
    private final LocalDateTime localDateTime;
    private final String message;
    private final String description;

    public ErrorDto(int statusCode, LocalDateTime localDateTime, String message, String description) {
        this.statusCode = statusCode;
        this.localDateTime = localDateTime;
        this.message = message;
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
