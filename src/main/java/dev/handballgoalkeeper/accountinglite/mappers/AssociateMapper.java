package dev.handballgoalkeeper.accountinglite.mappers;

import dev.handballgoalkeeper.accountinglite.DTOs.associates.AssociateDTO;
import dev.handballgoalkeeper.accountinglite.DTOs.requests.associates.CreateRequest;
import dev.handballgoalkeeper.accountinglite.mappers.abstractions.AssociateMapperInterface;
import dev.handballgoalkeeper.accountinglite.models.AssociateModel;
import dev.handballgoalkeeper.accountinglite.models.AssociateTypeModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AssociateMapper implements AssociateMapperInterface {
    @Override
    public <T> AssociateModel fromRequest(T request, AssociateTypeModel associateType) {
        if (!getAllowedRequestTypes().contains(request.getClass())) {
            throw new IllegalArgumentException("Not a valid request type: '" + request.getClass() + "' provided.");
        }

        AssociateModel.AssociateModelBuilder builder = AssociateModel.builder();
        builder.associateType(associateType);

        if (request instanceof CreateRequest createRequest) {
            builder
                    .displayName(createRequest.getDisplayName())
                    .taxId(createRequest.getTaxId())
                    .email(createRequest.getEmail())
                    .phone(createRequest.getPhone())
                    .address(createRequest.getAddress())
                    .city(createRequest.getCity())
                    .state(createRequest.getState())
                    .postalCode(createRequest.getPostalCode())
                    .country(createRequest.getCountry());
        }

        return builder.build();
    }

    @Override
    public AssociateModel toModel(AssociateDTO associateDTO) {
        return AssociateModel.builder()

                .build();
    }

    @Override
    public AssociateDTO toDTO(AssociateModel associateModel) {
        return AssociateDTO.builder()
                .id(associateModel.getId())
                .associateTypeId(associateModel.getAssociateType().getId())
                .displayName(associateModel.getDisplayName())
                .taxId(associateModel.getTaxId())
                .email(associateModel.getEmail())
                .phone(associateModel.getPhone())
                .address(associateModel.getAddress())
                .city(associateModel.getCity())
                .state(associateModel.getState())
                .postalCode(associateModel.getPostalCode())
                .country(associateModel.getCountry())
                .build();
    }

    private List<Class<?>> getAllowedRequestTypes() {
        return new ArrayList<>() {
            {
                add(CreateRequest.class);
            }
        };
    }
}
