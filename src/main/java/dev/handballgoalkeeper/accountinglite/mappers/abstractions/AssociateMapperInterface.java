package dev.handballgoalkeeper.accountinglite.mappers.abstractions;

import dev.handballgoalkeeper.accountinglite.DTOs.associates.AssociateDTO;
import dev.handballgoalkeeper.accountinglite.models.AssociateModel;
import dev.handballgoalkeeper.accountinglite.models.AssociateTypeModel;

public interface AssociateMapperInterface {
    <T> AssociateModel fromRequest (T request, AssociateTypeModel associateType);
    AssociateModel toModel (AssociateDTO associateDTO);
    AssociateDTO toDTO (AssociateModel associateModel);
}
