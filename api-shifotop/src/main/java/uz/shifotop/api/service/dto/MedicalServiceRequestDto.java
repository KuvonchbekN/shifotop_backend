package uz.shifotop.api.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record MedicalServiceRequestDto(
        @Schema(defaultValue = "1") @JsonProperty(value = "medical_service_id") Long medServiceId,
        @Schema(defaultValue = "1") @JsonProperty(value = "clinic_id") Long clinicId) {
}
