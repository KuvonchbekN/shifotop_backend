package uz.shifotop.api.clinicSpecs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record ClinicSpecCreateDto(
        @Schema(defaultValue = "Pediatric") @JsonProperty(value = "name") String name
) {
}
