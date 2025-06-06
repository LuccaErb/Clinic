package clinic.med.api.domain.dto.doctorDto;

import clinic.med.api.domain.dto.addressDto.DataAddressDto;
import clinic.med.api.domain.model.address.Address;
import jakarta.validation.constraints.NotNull;

public record DoctorDtoUpdate(
        @NotNull
        Long id,
        String name,
        String phone,
        DataAddressDto address) {
}
