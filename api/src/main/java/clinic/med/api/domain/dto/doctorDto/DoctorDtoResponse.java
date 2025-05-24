package clinic.med.api.domain.dto.doctorDto;

import clinic.med.api.domain.model.address.Address;
import clinic.med.api.domain.model.doctor.Doctor;
import clinic.med.api.domain.model.doctor.Specialty;


public record DoctorDtoResponse(Long id,
                                String name,
                                String email,
                                String phone,
                                String crm,
                                Specialty specialty,
                                Address address,
                                Boolean active) {
    public DoctorDtoResponse(Doctor doctor) {
        this(doctor.getId(),
            doctor.getName(),
            doctor.getEmail(),
            doctor.getPhone(),
            doctor.getCrm(),
            doctor.getSpecialty(),
            doctor.getAddress(),
            doctor.getActive());
    }
   
}
