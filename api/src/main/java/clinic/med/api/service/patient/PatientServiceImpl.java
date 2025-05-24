package clinic.med.api.service.patient;

import clinic.med.api.domain.dto.patientDto.PatientDto;
import clinic.med.api.domain.dto.patientDto.PatientDtoResponse;
import clinic.med.api.domain.dto.patientDto.PatientDtoUpdate;
import clinic.med.api.domain.model.patient.Patient;
import clinic.med.api.repositories.patient.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    @Transactional
    public PatientDtoResponse create(PatientDto patientDto) {
        Patient patient = new Patient(patientDto);
        patientRepository.save(patient);
        return new PatientDtoResponse(patient);

    }

    @Override
    public Page<PatientDtoResponse> findAllByActiveTrue(@PageableDefault(size = 10,sort = "name" ) Pageable pageable) {
        return patientRepository.findAllByActiveTrue(pageable).map(PatientDtoResponse::new);
    }

    @Override
    @Transactional
    public PatientDtoResponse update(PatientDtoUpdate patientDtoUpdate) {
        Patient patient = patientRepository.findById(patientDtoUpdate.id()).orElseThrow();
        patient.update(patientDtoUpdate);
        return new PatientDtoResponse(patient);
    }

    @Override
    @Transactional
    public ResponseEntity delete(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        patient.delete();
        return ResponseEntity.noContent().build();
    }

    @Override
    public PatientDtoResponse findById(Long id) {

        return patientRepository.findById(id).map(PatientDtoResponse::new)
                .orElseThrow();
    }
}
