package uz.shifotop.api.clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalServiceResponseDto {
    private Long id;
    private String name;
    private BigDecimal cost;
}
