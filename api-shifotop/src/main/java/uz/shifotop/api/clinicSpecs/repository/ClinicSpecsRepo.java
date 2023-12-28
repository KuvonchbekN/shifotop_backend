package uz.shifotop.api.clinicSpecs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.shifotop.api.clinicSpecs.entity.ClinicSpec;

import java.util.List;

public interface ClinicSpecsRepo extends JpaRepository<ClinicSpec, Long> {

    List<ClinicSpec> findAllByClinicsId(Long id);

    boolean existsByName(String name);
}
