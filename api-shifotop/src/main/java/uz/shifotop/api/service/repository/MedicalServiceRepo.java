package uz.shifotop.api.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.shifotop.api.service.entity.MedicalService;

import java.util.List;

public interface MedicalServiceRepo extends JpaRepository<MedicalService, Long> {

    List<MedicalService> findByNameContainingIgnoreCase(String name);

}
