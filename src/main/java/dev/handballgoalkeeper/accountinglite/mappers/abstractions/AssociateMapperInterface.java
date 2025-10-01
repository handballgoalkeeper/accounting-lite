package dev.handballgoalkeeper.accountinglite.mappers.abstractions;

import dev.handballgoalkeeper.accountinglite.DTOs.associatetype.AssociateTypeDTO;
import dev.handballgoalkeeper.accountinglite.models.AssociateTypeModel;

import java.util.List;

public interface AssociateMapperInterface {
    AssociateTypeDTO toDTO(AssociateTypeModel model);
    List<AssociateTypeDTO> toDTOList(List<AssociateTypeModel> models);
}
