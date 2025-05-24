package clinic.med.api.service.doctor;

import clinic.med.api.domain.dto.doctorDto.DoctorDto;
import clinic.med.api.domain.dto.doctorDto.DoctorDtoResponse;
import clinic.med.api.domain.dto.doctorDto.DoctorDtoUpdate;
import clinic.med.api.domain.dto.doctorDto.DoctorListingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DoctorService {

    DoctorDtoResponse create(DoctorDto doctorDto);

    DoctorDtoResponse updateDoctor( DoctorDtoUpdate doctorDto);

    void delete(Long id);

    Page<DoctorListingDto> findAllByActiveTrue(Pageable pageable);

    DoctorDtoResponse findById(Long id);
}
