package dev.handballgoalkeeper.accountinglite.controllers.v1;

import dev.handballgoalkeeper.accountinglite.DTOs.associatetype.AssociateTypeDTO;
import dev.handballgoalkeeper.accountinglite.DTOs.requests.PaginatedRequestDTO;
import dev.handballgoalkeeper.accountinglite.DTOs.responses.PaginatedResponseDTO;
import dev.handballgoalkeeper.accountinglite.DTOs.responses.SuccessResponseDTO;
import dev.handballgoalkeeper.accountinglite.services.abstractions.AssociateTypesServiceInterface;
import dev.handballgoalkeeper.accountinglite.services.abstractions.ResponseBuilderServiceInterface;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/associate-types")
public class AssociateTypesController {
    private final AssociateTypesServiceInterface associateTypesService;
    private final ResponseBuilderServiceInterface responseBuilderService;

    public AssociateTypesController(
            AssociateTypesServiceInterface associateTypesService,
            ResponseBuilderServiceInterface responseBuilderService
    ) {
        this.associateTypesService = associateTypesService;
        this.responseBuilderService = responseBuilderService;
    }


    @GetMapping("")
    public ResponseEntity<SuccessResponseDTO<PaginatedResponseDTO<AssociateTypeDTO>>> getAssociateTypes(
            @Valid PaginatedRequestDTO paginatedRequestDTO
    ) {
        var associateTypes = this.associateTypesService.findAllPaginated(
                paginatedRequestDTO.getPageNumber() - 1,
                paginatedRequestDTO.getPageSize()
        );

        return this.responseBuilderService.success(associateTypes, HttpStatus.OK);
    }
}
