package uz.shifotop.api.clinic.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ClinicResponseDto(@Schema(defaultValue = "1") Long id,
                                @Schema(defaultValue = "ShoxMedCenter") String name,
                                @Schema(defaultValue = "ShoxMedCenter") String officialName,
                                @Schema(defaultValue = "11111") String phoneNumber,
                                @Schema(defaultValue = "aaaaa") String supervisorName) {
}
