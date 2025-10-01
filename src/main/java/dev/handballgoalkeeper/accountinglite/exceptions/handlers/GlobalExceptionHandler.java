package dev.handballgoalkeeper.accountinglite.exceptions.handlers;

import dev.handballgoalkeeper.accountinglite.DTOs.responses.ErrorResponseDTO;
import dev.handballgoalkeeper.accountinglite.enums.ErrorMessage;
import dev.handballgoalkeeper.accountinglite.services.abstractions.ResponseBuilderServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final ResponseBuilderServiceInterface responseBuilderService;

    public GlobalExceptionHandler(ResponseBuilderServiceInterface responseBuilderService) {
        this.responseBuilderService = responseBuilderService;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        var errors = new HashMap<String, String>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return this.responseBuilderService.error(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponseDTO> handleUnhandledExceptions() {
        var errorMessages = new HashMap<String, String>();
        errorMessages.put("general", ErrorMessage.UNHANDLED_EXCEPTION.getMessage());

        return this.responseBuilderService.error(errorMessages, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
