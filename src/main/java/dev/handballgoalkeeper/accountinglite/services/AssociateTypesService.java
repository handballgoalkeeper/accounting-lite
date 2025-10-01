package dev.handballgoalkeeper.accountinglite.services;

import dev.handballgoalkeeper.accountinglite.DTOs.associatetype.AssociateTypeDTO;
import dev.handballgoalkeeper.accountinglite.DTOs.responses.PaginatedResponseDTO;
import dev.handballgoalkeeper.accountinglite.mappers.AssociateTypeMapper;
import dev.handballgoalkeeper.accountinglite.repositories.abstractions.AssociateTypeRepository;
import dev.handballgoalkeeper.accountinglite.services.abstractions.AssociateTypesServiceInterface;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AssociateTypesService implements AssociateTypesServiceInterface {
    private final AssociateTypeRepository associateTypeRepository;
    private final AssociateTypeMapper associateTypeMapper;

    public AssociateTypesService(
            AssociateTypeRepository associateTypeRepository,
            AssociateTypeMapper associateTypeMapper
    ) {
        this.associateTypeRepository = associateTypeRepository;
        this.associateTypeMapper = associateTypeMapper;
    }

    @Override
    public PaginatedResponseDTO<AssociateTypeDTO> findAllPaginated(int pageNumber, int pageSize) {
        var pageable = PageRequest.of(pageNumber, pageSize);

        var page = this.associateTypeRepository.findAll(pageable);

        return PaginatedResponseDTO.<AssociateTypeDTO>builder()
                .page(page.getNumber() + 1)
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .isFirstPage(page.isFirst())
                .isLastPage(page.isLast())
                .content(this.associateTypeMapper.toDTOList(page.getContent()))
                .build();
    }
}
