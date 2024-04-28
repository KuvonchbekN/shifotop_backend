package uz.shifotop.api.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.shifotop.api.review.dto.ReviewRequestDto;
import uz.shifotop.api.review.entity.Review;
import uz.shifotop.api.review.service.ReviewService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/clinics/{clinicId}/reviews")
    public ResponseEntity<HttpStatus> addReview(@PathVariable Long clinicId, @RequestBody ReviewRequestDto reviewRequestDto) {
        reviewService.addReviewToClinic(clinicId, reviewRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/doctors/{doctorId}/reviews")
    public ResponseEntity<HttpStatus> addReviewToDoctor(@PathVariable Long doctorId, @RequestBody ReviewRequestDto reviewRequestDto){
        reviewService.addReviewToDoctor(doctorId, reviewRequestDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}