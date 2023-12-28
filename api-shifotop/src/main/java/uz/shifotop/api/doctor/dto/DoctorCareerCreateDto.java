package uz.shifotop.api.doctor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DoctorCareerCreateDto(
        @JsonProperty("career_name") String careerName,
        @JsonProperty("career_role") String careerRole,
        @JsonProperty("career_date") String careerDate,
        @JsonProperty("career_type") String careerType,
        @JsonProperty("doctor_id") Long doctorId

) {
}
