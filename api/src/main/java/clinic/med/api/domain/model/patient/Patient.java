package clinic.med.api.domain.model.patient;

import clinic.med.api.domain.dto.patientDto.PatientDto;
import clinic.med.api.domain.dto.patientDto.PatientDtoResponse;
import clinic.med.api.domain.dto.patientDto.PatientDtoUpdate;
import clinic.med.api.domain.model.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "patients")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cpf;

    @Embedded
    private Address address;

    private Boolean active;

    public Patient(PatientDto patientDto) {
        this.active = true;
        this.name = patientDto.name();
        this.email = patientDto.email();
        this.phone = patientDto.phone();
        this.cpf = patientDto.cpf();
        this.address = new Address(patientDto.address());
    }


    public void update(PatientDtoUpdate patientDtoUpdate) {
        if (patientDtoUpdate.name() != null) this.name = patientDtoUpdate.name();
        if (patientDtoUpdate.email() != null) this.email = patientDtoUpdate.email();
        if (patientDtoUpdate.phone() != null) this.phone = patientDtoUpdate.phone();
        if (patientDtoUpdate.cpf() != null) this.cpf = patientDtoUpdate.cpf();
        if (patientDtoUpdate.address() != null) this.address.updateAddress(patientDtoUpdate.address());


    }

    public void delete() {
        this.active = false;
    }
}
