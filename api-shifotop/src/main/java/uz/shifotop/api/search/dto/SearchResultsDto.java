package uz.shifotop.api.search.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.shifotop.api.clinic.dto.ClinicResponseDto;
import uz.shifotop.api.clinic.dto.MedicalServiceResponseDto;
import uz.shifotop.api.doctor.dto.DoctorResponseDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SearchResultsDto {
    private List<DoctorResponseDto> doctors;
    private List<ClinicResponseDto> clinics;
    private List<MedicalServiceResponseDto> services;
}
