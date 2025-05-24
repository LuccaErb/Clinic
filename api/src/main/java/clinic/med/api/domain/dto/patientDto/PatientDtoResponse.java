package clinic.med.api.domain.dto.patientDto;

import clinic.med.api.domain.dto.addressDto.DataAddressDto;
import clinic.med.api.domain.model.address.Address;
import clinic.med.api.domain.model.patient.Patient;

public record PatientDtoResponse(

        Long id,


        String name,


        String email,


        String phone,


        String cpf,


        Address address,
        Boolean active) {


    public PatientDtoResponse(Patient patient) {
        this(patient.getId(),
             patient.getName(),
             patient.getEmail(),
             patient.getPhone(),
             patient.getCpf(),
             patient.getAddress(), patient.getActive());

    }
}
