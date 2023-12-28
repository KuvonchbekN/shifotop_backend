package uz.shifotop.api.clinic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record OrientalPlaceDto(
        @Schema(defaultValue = "1") @JsonProperty(value = "clinic_id") Long clinicId,
        @Schema(defaultValue = "1") @JsonProperty(value = "orient_id") Long orientId) {
}
