package uz.shifotop.api.clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.shifotop.api.address.dto.AddressResponseDto;
import uz.shifotop.api.clinicSpecs.dto.ClinicSpecsResponseDto;
import uz.shifotop.api.doctor.dto.DoctorResponseDto;
import uz.shifotop.api.review.dto.ReviewResponseDto;
import uz.shifotop.api.service.dto.MedicalServiceResponseDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClinicResponseDto {
    private Long id;
    private String name;
    private String officialName;
    private String phoneNumber;
    private String supervisorName;
    private List<DoctorResponseDto> doctors;
    private List<MedicalServiceResponseDto>medicalServices;
    private AddressResponseDto address;
    private List<AddressResponseDto>orientalPlaces;
    private List<ClinicSpecsResponseDto> clinicSpecs;
    private List<ReviewResponseDto> reviews;
    private double rating;
}
