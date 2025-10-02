package dev.handballgoalkeeper.accountinglite.controllers.v1;

import dev.handballgoalkeeper.accountinglite.DTOs.associates.AssociateDTO;
import dev.handballgoalkeeper.accountinglite.DTOs.requests.associates.CreateRequest;
import dev.handballgoalkeeper.accountinglite.DTOs.responses.SuccessResponseDTO;
import dev.handballgoalkeeper.accountinglite.services.abstractions.AssociateServiceInterface;
import dev.handballgoalkeeper.accountinglite.services.abstractions.ResponseBuilderServiceInterface;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/associates")
public class AssociatesController {
    private final AssociateServiceInterface associateService;
    private final ResponseBuilderServiceInterface responseBuilderService;

    public AssociatesController(AssociateServiceInterface associateService,
                                ResponseBuilderServiceInterface responseBuilderService) {
        this.associateService = associateService;
        this.responseBuilderService = responseBuilderService;
    }

    @PostMapping
    public ResponseEntity<SuccessResponseDTO<AssociateDTO>> create(@RequestBody @Valid CreateRequest request) {
        var createdAssociate = this.associateService.createFromRequest(request);
        return this.responseBuilderService.success(createdAssociate, HttpStatus.CREATED);
    }

}
