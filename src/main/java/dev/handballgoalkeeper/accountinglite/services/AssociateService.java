package dev.handballgoalkeeper.accountinglite.services;

import dev.handballgoalkeeper.accountinglite.DTOs.associates.AssociateDTO;
import dev.handballgoalkeeper.accountinglite.DTOs.requests.associates.CreateRequest;
import dev.handballgoalkeeper.accountinglite.exceptions.AlreadyExistsException;
import dev.handballgoalkeeper.accountinglite.exceptions.NotFoundException;
import dev.handballgoalkeeper.accountinglite.mappers.abstractions.AssociateMapperInterface;
import dev.handballgoalkeeper.accountinglite.models.AssociateModel;
import dev.handballgoalkeeper.accountinglite.repositories.AssociateRepository;
import dev.handballgoalkeeper.accountinglite.repositories.AssociateTypeRepository;
import dev.handballgoalkeeper.accountinglite.services.abstractions.AssociateServiceInterface;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssociateService implements AssociateServiceInterface {
    private final AssociateRepository associateRepository;
    private final AssociateMapperInterface associateMapper;
    private final AssociateTypeRepository associateTypeRepository;

    public AssociateService(AssociateRepository associateRepository,
                            AssociateMapperInterface associateMapper,
                            AssociateTypeRepository associateTypeRepository) {
        this.associateRepository = associateRepository;
        this.associateMapper = associateMapper;
        this.associateTypeRepository = associateTypeRepository;
    }

    @Override
    public AssociateDTO createFromRequest(CreateRequest createRequest) {
        if (createRequest == null) {
            throw new IllegalArgumentException("Request cannot be null.");
        }

        if (this.associateRepository.existsByDisplayName(createRequest.getDisplayName())) {
            throw new AlreadyExistsException("Associate with given display name already exists.");
        }

        var associateType = this.associateTypeRepository
                .findById(createRequest.getAssociateTypeId())
                .orElseThrow(() -> new NotFoundException("Associate type with given id does not exist."));

        var model = this.associateMapper.fromRequest(createRequest, associateType);
        var createdAssociate = this.associateRepository.save(model);

        return this.associateMapper.toDTO(createdAssociate);
    }

    @Override
    public AssociateModel update(AssociateModel associateModel) {
        return this.associateRepository.save(associateModel);
    }

    @Override
    public List<AssociateModel> findAll() {
        return this.associateRepository.findAll();
    }
}
