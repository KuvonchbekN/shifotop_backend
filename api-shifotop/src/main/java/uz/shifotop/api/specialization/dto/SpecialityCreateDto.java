package uz.shifotop.api.specialization.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SpecialityCreateDto(
        @JsonProperty("name") String name
) {
}
