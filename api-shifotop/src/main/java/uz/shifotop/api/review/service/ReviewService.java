package uz.shifotop.api.review.service;

import org.springframework.stereotype.Service;
import uz.shifotop.api.review.dto.ReviewRequestDto;
import uz.shifotop.api.review.entity.Review;

@Service
public interface ReviewService {
    void addReviewToClinic(Long clinicId, ReviewRequestDto reviewRequestDto);

    void addReviewToDoctor(Long doctorId, ReviewRequestDto reviewRequestDto);
}
