package dev.handballgoalkeeper.accountinglite.services.abstractions;

import dev.handballgoalkeeper.accountinglite.DTOs.responses.ErrorResponseDTO;
import dev.handballgoalkeeper.accountinglite.DTOs.responses.SuccessResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ResponseBuilderServiceInterface {
    <T> ResponseEntity<SuccessResponseDTO<T>> success(T data, HttpStatus statusCode);
    ResponseEntity<ErrorResponseDTO> error(Map<String, String> messages, HttpStatus statusCode);
}
