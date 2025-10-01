package dev.handballgoalkeeper.accountinglite.DTOs.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginatedResponseDTO<T> {
    private int page;
    private int size;
    private long totalElements;
    private boolean isLastPage;
    private boolean isFirstPage;
    private int totalPages;
    private List<T> content;
}
