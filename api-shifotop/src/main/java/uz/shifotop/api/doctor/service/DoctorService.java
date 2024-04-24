package uz.shifotop.api.doctor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.shifotop.api.clinic.dto.ClinicResponseDto;
import uz.shifotop.api.clinic.entity.Clinic;
import uz.shifotop.api.clinic.mapper.ClinicMapper;
import uz.shifotop.api.clinic.repository.ClinicRepo;
import uz.shifotop.api.doctor.dto.DoctorCreateDto;
import uz.shifotop.api.doctor.dto.DoctorResponseDto;
import uz.shifotop.api.doctor.dto.DoctorSpecialityCountDto;
import uz.shifotop.api.doctor.entity.Doctor;
import uz.shifotop.api.doctor.mapper.DoctorMapper;
import uz.shifotop.api.doctor.repository.DoctorRepository;
import uz.shifotop.api.review.dto.ReviewResponseDto;
import uz.shifotop.api.review.entity.Review;
import uz.shifotop.api.review.repository.ReviewRepository;
import uz.shifotop.api.specialization.dto.SpecialityResponseDto;
import uz.shifotop.api.specialization.entity.Specialities;
import uz.shifotop.api.specialization.repository.SpecialitiesRepository;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;
    private final SpecialitiesRepository specialitiesRepository;
    private final ReviewRepository reviewRepository;
    private final ClinicRepo clinicRepo;
    private final ClinicMapper clinicMapper;

    public List<DoctorResponseDto> getAllDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();
        List<DoctorResponseDto> doctorResponseDtoList = new ArrayList<>();
        for (var doctor : doctorList) {
            DoctorResponseDto doctorResponseDto = doctorMapper.doctorToDoctorResponseDto(doctor);
            convertFromDoctorToResponseDto(doctor, doctorResponseDto);
            doctorResponseDtoList.add(doctorResponseDto);
        }
        return doctorResponseDtoList;
    }

    public DoctorResponseDto getDoctor(long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        DoctorResponseDto doctorResponseDto = doctorMapper.doctorToDoctorResponseDto(doctor);
        convertFromDoctorToResponseDto(doctor, doctorResponseDto);
        return doctorResponseDto;
    }

    private void convertFromDoctorToResponseDto(Doctor doctor, DoctorResponseDto doctorResponseDto) {
        //attach the specialities to the doctorResponseDto
        List<Specialities> specialities = specialitiesRepository.findByDoctors_Id(doctor.getId());
        attachSpecialitiesToDoctorResponseDto(specialities, doctorResponseDto);

        //attach the reviews to the doctorResponseDto
        List<Review> reviews = reviewRepository.findByDoctor_Id(doctor.getId());
        //attach the rating calculation to the doctorResponseDto
        double rating = calculateRatingFromReviews(reviews);
        doctorResponseDto.setRating(rating);
        attachReviewsToDoctorResponseDto(reviews, doctorResponseDto);

        //attach clinics to the dto
        Set<Clinic> clinics = clinicRepo.findByDoctors_Id(doctor.getId());
        List<ClinicResponseDto> clinicResponseDtos = clinicMapper.clinicListToClinicResponseDtoList(new ArrayList<>(clinics));
        doctorResponseDto.setClinics(clinicResponseDtos);
    }

    private double calculateRatingFromReviews(List<Review> reviews) {
        int cnt = 0;
        int sum = 0;
        for (Review review : reviews) {
            sum += review.getRating();
            cnt++;
        }
        return (double) sum / (double) cnt;
    }

    private void attachReviewsToDoctorResponseDto(List<Review> reviews, DoctorResponseDto doctorResponseDto) {
        List<ReviewResponseDto> reviewResponseDtos = new ArrayList<>();
        for (Review review : reviews) {
            ReviewResponseDto reviewResponseDto = new ReviewResponseDto(review.getId(),
                    review.getPatient() == null ? -1 : review.getPatient().getId(),
                    review.getDoctor() == null ? -1 : review.getDoctor().getId(),
                    review.getClinic() == null ? -1 : review.getClinic().getId(),
                    review.getRating(),
                    review.getContent(),
                    review.getReviewDate());
            reviewResponseDtos.add(reviewResponseDto);
        }
        doctorResponseDto.setReviews(reviewResponseDtos);
    }

    private void attachSpecialitiesToDoctorResponseDto(List<Specialities> specialities, DoctorResponseDto doctorResponseDto) {
        List<SpecialityResponseDto> specialityResponseDtos = new ArrayList<>();
        for (Specialities speciality : specialities) {
            SpecialityResponseDto specialityResponseDto = new SpecialityResponseDto(speciality.getName());
            specialityResponseDtos.add(specialityResponseDto);
        }
        doctorResponseDto.setSpecialities(specialityResponseDtos);
    }

    public DoctorResponseDto createDoctor(DoctorCreateDto dto) {
        Doctor doctor = doctorMapper.doctorCreateDtoToDoctor(dto);
        doctorRepository.save(doctor);
        return doctorMapper.doctorToDoctorResponseDto(doctor);
    }


    public List<DoctorResponseDto> getDoctorsBySpeciality(Long specId, Integer page, Integer size) {

        Pageable pageRequest = PageRequest.of(page, size);
        List<Doctor> doctors = doctorRepository.findAll(pageRequest).toList();

        return doctors.stream()
                .map(doctorMapper::doctorToDoctorResponseDto)
                .collect(Collectors.toList());
    }

    public List<DoctorSpecialityCountDto> getDoctorsSpecialitiesWithCount() {
        //get speciality name and count of doctors attached to that speciality
        List<DoctorSpecialityCountDto> result = new ArrayList<>();
        List<Specialities> allSpecialities = specialitiesRepository.findAll();
        for (int i = 0; i < 4; i++) {
            Specialities specialities = allSpecialities.get(i);
            DoctorSpecialityCountDto doctorSpecialityCountDto = new DoctorSpecialityCountDto(specialities.getName(), specialities.getDoctors().size());
            result.add(doctorSpecialityCountDto);
        }
        return result;
    }

    public Long getDoctorsCount() {
        return doctorRepository.count();
    }
}
