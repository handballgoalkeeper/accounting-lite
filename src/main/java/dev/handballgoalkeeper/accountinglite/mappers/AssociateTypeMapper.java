package dev.handballgoalkeeper.accountinglite.mappers;

import dev.handballgoalkeeper.accountinglite.DTOs.associatetype.AssociateTypeDTO;
import dev.handballgoalkeeper.accountinglite.mappers.abstractions.AssociateTypeMapperInterface;
import dev.handballgoalkeeper.accountinglite.models.AssociateTypeModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssociateTypeMapper implements AssociateTypeMapperInterface {
    @Override
    public AssociateTypeDTO toDTO(AssociateTypeModel model) {
        return AssociateTypeDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .build();
    }

    @Override
    public List<AssociateTypeDTO> toDTOList(List<AssociateTypeModel> models) {
        return models.stream().map(this::toDTO).toList();
    }
}
