package clinic.med.api.controller.patient;

import clinic.med.api.domain.dto.patientDto.PatientDto;
import clinic.med.api.domain.dto.patientDto.PatientDtoResponse;
import clinic.med.api.domain.dto.patientDto.PatientDtoUpdate;
import clinic.med.api.service.patient.PatientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService service;
    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PatientDtoResponse> createPatient(@RequestBody @Valid PatientDto patientDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(patientDto));

    }
    @GetMapping
    public ResponseEntity<Page<PatientDtoResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAllByActiveTrue(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDtoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @PutMapping
    public ResponseEntity<PatientDtoResponse> updatePatient( @RequestBody @Valid PatientDtoUpdate patientDtoUpdate) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(patientDtoUpdate));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity deletePatient(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
