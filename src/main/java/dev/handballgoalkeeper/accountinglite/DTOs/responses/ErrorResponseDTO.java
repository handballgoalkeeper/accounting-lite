package dev.handballgoalkeeper.accountinglite.DTOs.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDTO {
    private boolean success = false;
    private Map<String, String> messages;
    private LocalDateTime timestamp;
}
