package clinic.med.api.domain.dto.addressDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataAddressDto(
        @NotBlank
        String publicPlace,

        @NotBlank
        String neighborhood,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        String city,

        @NotBlank
        String uf,


        String complement,


        String number) {
}
