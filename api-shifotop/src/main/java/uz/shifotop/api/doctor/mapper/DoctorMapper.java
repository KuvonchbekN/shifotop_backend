package uz.shifotop.api.doctor.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.shifotop.api.doctor.dto.DoctorCreateDto;
import uz.shifotop.api.doctor.dto.DoctorResponseDto;
import uz.shifotop.api.doctor.entity.Doctor;
import uz.shifotop.api.user.dto.UserCreateDto;
import uz.shifotop.api.user.entity.User;

@Component
public interface DoctorMapper {
    User userCreateDtoToUser(UserCreateDto userCreateDto);

    Doctor doctorCreateDtoToDoctor(DoctorCreateDto doctorDto);

    DoctorResponseDto doctorToDoctorResponseDto(Doctor doctor);
}


