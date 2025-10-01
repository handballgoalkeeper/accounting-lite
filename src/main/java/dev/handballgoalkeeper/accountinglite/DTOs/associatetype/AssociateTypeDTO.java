package dev.handballgoalkeeper.accountinglite.DTOs.associatetype;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssociateTypeDTO {
    private Long id;
    private String name;
    private String description;
}
