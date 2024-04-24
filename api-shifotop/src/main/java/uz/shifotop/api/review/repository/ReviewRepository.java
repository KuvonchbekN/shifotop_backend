package uz.shifotop.api.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.shifotop.api.review.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByDoctor_Id(Long doctorId);

}