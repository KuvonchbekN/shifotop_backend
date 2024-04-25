package uz.shifotop.api.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.shifotop.api.doctor.entity.Doctor;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	@Override
	List<Doctor> findAll();

	List<Doctor> findByFirstnameContainingIgnoreCase(String firstName);
	List<Doctor> findByLastnameContainingIgnoreCase(String lastName);

}
