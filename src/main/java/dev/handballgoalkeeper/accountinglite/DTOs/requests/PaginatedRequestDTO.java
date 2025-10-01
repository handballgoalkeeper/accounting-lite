package dev.handballgoalkeeper.accountinglite.DTOs.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedRequestDTO {
    @NotNull(message = "Query param 'pageNumber' is required.")
    @Min(value = 1, message = "Query param 'pageNumber' must be greater than or equal to 1.")
    private int pageNumber;
    @NotNull(message = "Query param 'pageSize' is required.")
    @Min(value = 1, message = "Query param 'pageSize' must be greater than or equal to 1.")
    private int pageSize;
}
