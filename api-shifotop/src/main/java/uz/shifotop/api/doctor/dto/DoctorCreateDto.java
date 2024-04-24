package uz.shifotop.api.doctor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record DoctorCreateDto(
        @JsonProperty(value = "firstname") String firstname,
        @JsonProperty(value = "lastname") String lastname,
        @JsonProperty(value = "phoneNumber") String phoneNumber,
        @JsonProperty(value = "bio") String bio,
        @JsonProperty(value = "career_start_year") int careerStartYear,
        @JsonProperty(value = "email") String email,
        @JsonProperty(value = "password") String password,
        @JsonProperty(value = "date_of_birth")LocalDate dateOfBirth,
        @JsonProperty(value = "price") double price
        )
{
}
