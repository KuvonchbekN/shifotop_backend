package uz.shifotop.api.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.shifotop.api.clinic.entity.MedicalService;

public interface MedicalServiceRepo extends JpaRepository<MedicalService, Long> {
}
