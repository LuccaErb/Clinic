package clinic.med.api.controller.doctor;

import clinic.med.api.domain.dto.doctorDto.DoctorDto;
import clinic.med.api.domain.dto.doctorDto.DoctorDtoResponse;
import clinic.med.api.domain.dto.doctorDto.DoctorDtoUpdate;
import clinic.med.api.domain.dto.doctorDto.DoctorListingDto;
import clinic.med.api.service.doctor.DoctorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<DoctorDtoResponse> createDoctor(@RequestBody @Valid DoctorDto doctorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(doctorDto));

    }

    @GetMapping
    public ResponseEntity<Page<DoctorListingDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAllByActiveTrue(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DoctorDtoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<DoctorDtoResponse> updateDoctor( @RequestBody @Valid DoctorDtoUpdate doctorDto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateDoctor(doctorDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable Long id) {
        service.delete(id);
    }
}