package uz.shifotop.api.clinic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record ClinicRequestDto(@Schema(defaultValue = "ShoxMedCenter") @JsonProperty(value = "name") String name,
                               @Schema(defaultValue = "ShoxMed MCHJ") @JsonProperty(value = "official_name") String officialName,
                               @Schema(defaultValue = "+998993352414") @JsonProperty(value = "phone_number") String phoneNumber,
                               @Schema(defaultValue = "Mr.Akmal") @JsonProperty(value = "supervisor_name") String supervisorName) {
}
