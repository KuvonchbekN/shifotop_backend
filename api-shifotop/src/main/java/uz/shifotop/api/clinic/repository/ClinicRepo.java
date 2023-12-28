package uz.shifotop.api.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.shifotop.api.clinic.entity.Clinic;

import java.util.List;
import java.util.Set;

public interface ClinicRepo extends JpaRepository<Clinic, Long> {
    Set<Clinic> findAllByIdIn(List<Long> id);
}
