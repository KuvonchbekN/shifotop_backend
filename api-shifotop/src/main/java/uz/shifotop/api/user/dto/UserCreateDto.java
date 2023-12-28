package uz.shifotop.api.user.dto;

import uz.shifotop.api.user.enums.UserRole;

import java.time.LocalDate;
import java.util.List;

public record UserCreateDto(String firstName, String lastName, String phoneNumber, String email, String password,
                            LocalDate dateOfBirth, List<Long> clinicIds, String role) {

    public UserCreateDto {
        role = role.toUpperCase();
        if (!role.equals(UserRole.ADMIN.name()) && !role.equals(UserRole.PATIENT.name())) {
            throw new RuntimeException("wrong role entered"); //TODO need to implement our own exception class
        }
    }
}