package clinic.med.api.service.patient;

import clinic.med.api.domain.dto.patientDto.PatientDto;
import clinic.med.api.domain.dto.patientDto.PatientDtoResponse;
import clinic.med.api.domain.dto.patientDto.PatientDtoUpdate;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PatientService {


    PatientDtoResponse create(PatientDto patientDto);

    Page<PatientDtoResponse> findAllByActiveTrue(Pageable pageable);

    PatientDtoResponse update (PatientDtoUpdate patientDtoUpdate);

    ResponseEntity delete(Long id);

    PatientDtoResponse findById(Long id);
}
