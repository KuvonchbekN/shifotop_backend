package uz.shifotop.api.review.service;

import org.springframework.stereotype.Service;
import uz.shifotop.api.review.entity.Review;

@Service
public interface ReviewService {
    void addReviewToClinic(Long clinicId, Review review);

    void addReviewToDoctor(Long doctorId, Review review);
}
