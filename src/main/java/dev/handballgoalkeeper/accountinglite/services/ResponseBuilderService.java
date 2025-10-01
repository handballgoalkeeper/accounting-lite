package dev.handballgoalkeeper.accountinglite.services;

import dev.handballgoalkeeper.accountinglite.DTOs.responses.ErrorResponseDTO;
import dev.handballgoalkeeper.accountinglite.DTOs.responses.SuccessResponseDTO;
import dev.handballgoalkeeper.accountinglite.services.abstractions.ResponseBuilderServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
public class ResponseBuilderService implements ResponseBuilderServiceInterface {
    @Override
    public <T> ResponseEntity<SuccessResponseDTO<T>> success(T data, HttpStatus statusCode) {
        if (statusCode.value() < 200 || statusCode.value() >= 300)
        {
            throw new IllegalArgumentException(
                    "Invalid status code, must be in range [200, 300): " + statusCode.value() + "provided.");
        }

        var successResponse = SuccessResponseDTO.<T>builder().data(data).build();

        return new ResponseEntity<>(successResponse, statusCode);
    }

    @Override
    public ResponseEntity<ErrorResponseDTO> error(Map<String, String> messages, HttpStatus statusCode) {
        if (statusCode.value() < 400 || statusCode.value() >= 599)
        {
            throw new IllegalArgumentException(
                    "Invalid status code, must be in range [400, 599): " + statusCode.value() + "provided.");
        }

        var errorResponse = ErrorResponseDTO.builder().messages(messages).timestamp(LocalDateTime.now()).build();

        return new ResponseEntity<>(errorResponse, statusCode);
    }
}
