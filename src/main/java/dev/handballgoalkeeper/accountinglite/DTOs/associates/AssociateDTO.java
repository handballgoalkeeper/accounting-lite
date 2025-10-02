package dev.handballgoalkeeper.accountinglite.DTOs.associates;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssociateDTO {
    private Long id;
    private Long associateTypeId;
    private String displayName;
    private String taxId;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
