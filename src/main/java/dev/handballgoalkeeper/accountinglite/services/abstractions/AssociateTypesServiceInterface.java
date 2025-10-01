package dev.handballgoalkeeper.accountinglite.services.abstractions;

import dev.handballgoalkeeper.accountinglite.DTOs.associatetype.AssociateTypeDTO;
import dev.handballgoalkeeper.accountinglite.DTOs.responses.PaginatedResponseDTO;

public interface AssociateTypesServiceInterface {
    PaginatedResponseDTO<AssociateTypeDTO> findAllPaginated(int page, int size);
}
