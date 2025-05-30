package clinic.med.api.domain.dto.patientDto;

import clinic.med.api.domain.dto.addressDto.DataAddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record PatientDto(
        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String phone,

        @NotBlank
        @CPF
        String cpf,

        @NotNull
        @Valid
        DataAddressDto address) {

}
