package dev.handballgoalkeeper.accountinglite.DTOs.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuccessResponseDTO<T> {
    @Builder.Default
    private boolean success = true;
    private T data;
    private Map<String, String> messages;
}
