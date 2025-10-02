package dev.handballgoalkeeper.accountinglite.services.abstractions;

import dev.handballgoalkeeper.accountinglite.DTOs.associates.AssociateDTO;
import dev.handballgoalkeeper.accountinglite.DTOs.requests.associates.CreateRequest;
import dev.handballgoalkeeper.accountinglite.models.AssociateModel;

import java.util.List;

public interface AssociateServiceInterface {
    AssociateDTO createFromRequest(CreateRequest createRequest);
    AssociateModel update(AssociateModel associateModel);
    List<AssociateModel> findAll();
}
