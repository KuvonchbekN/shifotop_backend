package uz.shifotop.api.doctor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.shifotop.api.address.dto.AddressResponseDto;
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
    private String workCategory;
    private int price;
    private AddressResponseDto address;
    private List<SpecialityResponseDto> specialities;
    private int yearOfExperience;
    private int reviews;
    private float rating;
}
