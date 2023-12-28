package uz.shifotop.api.doctor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DoctorCreateDto(
    @JsonProperty(value = "firstname") String firstname,
    @JsonProperty(value = "lastname") String lastname,
    @JsonProperty(value = "phoneNumber") String phoneNumber,
    @JsonProperty(value = "email") String email,
    @JsonProperty(value = "password") String password,
    @JsonProperty(value = "doctor_career") DoctorCareerCreateDto doctorCareer
)
{
}
