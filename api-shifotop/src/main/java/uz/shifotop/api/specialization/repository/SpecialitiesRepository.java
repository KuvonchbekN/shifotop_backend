package uz.shifotop.api.specialization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.shifotop.api.doctor.entity.Doctor;
import uz.shifotop.api.specialization.entity.Specialities;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialitiesRepository extends JpaRepository<Specialities, Long> {

    boolean existsByName(String name);

    List<Specialities> findByDoctors_Id(Long doctorId);
}
