package uz.shifotop.api.doctor.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.shifotop.api.doctor.dto.DoctorCreateDto;
import uz.shifotop.api.doctor.dto.DoctorResponseDto;
import uz.shifotop.api.doctor.entity.Doctor;
import uz.shifotop.api.user.dto.UserCreateDto;
import uz.shifotop.api.user.entity.User;

import java.time.Year;
import java.util.Date;

@Component
public class DoctorMapperImpl implements DoctorMapper {
    @Override
    public User userCreateDtoToUser(UserCreateDto userCreateDto) {
        return null;
    }

    @Override
    public Doctor doctorCreateDtoToDoctor(DoctorCreateDto doctorDto) {
        return new Doctor(null,
                doctorDto.firstname(),
                doctorDto.lastname(),
                doctorDto.phoneNumber(),
                doctorDto.bio(),
                doctorDto.careerStartYear(),
                doctorDto.email(),
                doctorDto.password(),
                doctorDto.dateOfBirth(),
                doctorDto.price(),
                null,
                null);
    }

    @Override
    public DoctorResponseDto doctorToDoctorResponseDto(Doctor doctor) {
        return new DoctorResponseDto(doctor.getId(),
                doctor.getFirstname(),
                doctor.getLastname(),
                doctor.getPhoneNumber(),
                doctor.getBio(),
                Year.now().getValue() - doctor.getCareerStartYear(),
                doctor.getPrice(),
                null,
                null,
                null,
                0
                );
    }
}
