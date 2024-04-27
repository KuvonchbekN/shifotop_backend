package uz.shifotop.api.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.shifotop.api.clinic.dto.ClinicResponseDto;
import uz.shifotop.api.clinic.entity.Clinic;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalServiceResponseDto {
    private Long id;
    private String name;
    private BigDecimal cost;
    private List<ClinicResponseDto> clinics;
}
