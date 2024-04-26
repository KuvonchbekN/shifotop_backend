package uz.shifotop.api.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.shifotop.api.clinic.dto.ClinicResponseDto;
import uz.shifotop.api.clinic.entity.Clinic;
import uz.shifotop.api.clinic.repository.ClinicRepo;
import uz.shifotop.api.clinic.service.ClinicService;
import uz.shifotop.api.common.exception.NotFoundException;
import uz.shifotop.api.doctor.entity.Doctor;
import uz.shifotop.api.doctor.repository.DoctorRepository;
import uz.shifotop.api.review.entity.Review;
import uz.shifotop.api.review.repository.ReviewRepository;
import uz.shifotop.api.user.entity.User;
import uz.shifotop.api.user.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService{
    private final ClinicService clinicService;
    private final ClinicRepo clinicRepo;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public void addReviewToClinic(Long clinicId, Review review) {
        User user = getRandomPatient();

        Optional<Clinic> byId = clinicRepo.findById(clinicId);
        if (byId.isEmpty()){
            throw new NotFoundException("Clinic with this id does not exist");
        }

//        user.setClinics(null);
        review.setReviewDate(LocalDateTime.now());
        review.setPatient(user);
        review.setClinic(byId.get());
        reviewRepository.save(review);
    }

    @Override
    public void addReviewToDoctor(Long doctorId, Review review) {
        User user = getRandomPatient();
        Optional<Doctor> byId = doctorRepository.findById(doctorId);
        if (byId.isEmpty()){
            throw new NotFoundException("Doctor with this id does not exist");
        }

        review.setReviewDate(LocalDateTime.now());
        review.setPatient(user);
        review.setDoctor(byId.get());
        reviewRepository.save(review);
    }

    private User getRandomPatient(){
        //todo as for now, lets put random patient id since we don't have the authentication
        Optional<User> allUsers = userRepository.findAll().stream().findFirst();
        if (allUsers.isEmpty()){
            throw new NotFoundException("There is no any user associated with the clinic");
        }
        return allUsers.get();
    }
}
