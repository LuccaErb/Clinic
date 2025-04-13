package clinic.med.api.domain.model.doctor;

import clinic.med.api.domain.dto.doctorDto.DoctorDto;
import clinic.med.api.domain.dto.doctorDto.DoctorDtoUpdate;
import clinic.med.api.domain.model.address.Address;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "doctors")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String crm;


    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    private Boolean active ;

    public Doctor(DoctorDto doctorDto) {
        this.active = true;
        this.name = doctorDto.name();
        this.email = doctorDto.email();
        this.phone = doctorDto.phone();
        this.crm = doctorDto.crm();
        this.specialty = doctorDto.specialty();

        this.address = new Address(doctorDto.address());

    }

    public void updateDoctor(DoctorDtoUpdate doctorDto) {
        if (doctorDto.name() != null) {
            this.name = doctorDto.name();
        }
        if(doctorDto.phone() != null) {
            this.phone = doctorDto.phone();
        }
        if (doctorDto.address() != null) {
            this.address.updateDoctor(doctorDto.address());
        }
    }

    public void delete() {
        this.active = false;
    }
}
