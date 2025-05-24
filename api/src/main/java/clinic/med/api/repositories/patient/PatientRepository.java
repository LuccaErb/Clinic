package clinic.med.api.repositories.patient;

import clinic.med.api.domain.model.patient.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


    Page<Patient> findAllByActiveTrue(Pageable pageable);
}
