package dev.handballgoalkeeper.accountinglite.DTOs.requests.associates;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class CreateRequest {
    @NotNull(message = "Associate type id is required.")
    private Long associateTypeId;
    @NotBlank(message = "Display name is required.")
    private String displayName;
    @Pattern(regexp = "^(?!\\s*$).+", message = "Must not be blank if provided.")
    private String taxId;
    @Pattern(regexp = "^(?!\\s*$).+", message = "Must not be blank if provided.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email address.")
    private String email;
    @Pattern(regexp = "^(?!\\s*$).+", message = "Must not be blank if provided.")
    private String phone;
    @Pattern(regexp = "^(?!\\s*$).+", message = "Must not be blank if provided.")
    private String address;
    @Pattern(regexp = "^(?!\\s*$).+", message = "Must not be blank if provided.")
    private String city;
    @Pattern(regexp = "^(?!\\s*$).+", message = "Must not be blank if provided.")
    private String state;
    @Pattern(regexp = "^(?!\\s*$).+", message = "Must not be blank if provided.")
    private String postalCode;
    @Pattern(regexp = "^(?!\\s*$).+", message = "Must not be blank if provided.")
    private String country;
}
