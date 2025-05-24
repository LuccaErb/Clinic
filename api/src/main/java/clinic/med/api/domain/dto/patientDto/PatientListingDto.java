package clinic.med.api.domain.dto.patientDto;

import clinic.med.api.domain.model.patient.Patient;

public record PatientListingDto(
    Long id,
    String name,
    String email,
    String cpf
) {
    public PatientListingDto(Patient patient) {
        this(patient.getId(),
            patient.getName(),
            patient.getEmail(),
            patient.getCpf());
    }
}
