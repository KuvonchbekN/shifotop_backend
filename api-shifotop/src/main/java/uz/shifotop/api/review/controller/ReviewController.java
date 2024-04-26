package uz.shifotop.api.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.shifotop.api.review.entity.Review;
import uz.shifotop.api.review.service.ReviewService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/clinics/{clinicId}/reviews")
    public ResponseEntity<HttpStatus> addReview(@PathVariable Long clinicId, @RequestBody Review review) {
        reviewService.addReviewToClinic(clinicId, review);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/doctors/{doctorId}/reviews")
    public ResponseEntity<HttpStatus> addReviewToDoctor(@PathVariable Long doctorId, @RequestBody Review review){
        reviewService.addReviewToDoctor(doctorId, review);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}