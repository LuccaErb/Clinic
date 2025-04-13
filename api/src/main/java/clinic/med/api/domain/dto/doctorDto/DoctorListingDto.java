package clinic.med.api.domain.dto.doctorDto;

import clinic.med.api.domain.model.doctor.Doctor;
import clinic.med.api.domain.model.doctor.Specialty;

public record DoctorListingDto(
    Long id,
    String name,
    String email,
    String crm,
    Specialty specialty
) {
    public DoctorListingDto(Doctor doctor) {
        this(doctor.getId(),
            doctor.getName(),
            doctor.getEmail(),
            doctor.getCrm(),
            doctor.getSpecialty());

    }
}
