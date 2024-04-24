package uz.shifotop.api.doctor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.shifotop.api.address.dto.AddressResponseDto;
import uz.shifotop.api.clinic.dto.ClinicResponseDto;
import uz.shifotop.api.review.dto.ReviewResponseDto;
import uz.shifotop.api.review.entity.Review;
import uz.shifotop.api.specialization.dto.SpecialityResponseDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponseDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
//    private String workCategory;
    private String bio;
    private int experience; //now-careerStartYear
    private double price;
    private List<SpecialityResponseDto> specialities;
    private List<ReviewResponseDto> reviews;
    private List<ClinicResponseDto> clinics;
    private double rating;
}
