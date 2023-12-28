package uz.shifotop.api.doctor.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.shifotop.api.doctor.dto.DoctorCreateDto;
import uz.shifotop.api.doctor.dto.DoctorResponseDto;
import uz.shifotop.api.doctor.entity.Doctor;
import uz.shifotop.api.user.dto.UserCreateDto;
import uz.shifotop.api.user.entity.User;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DoctorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "clinics", ignore = true)
    User userCreateDtoToUser(UserCreateDto userCreateDto);

    Doctor doctorCreateDtoToDoctor(DoctorCreateDto doctorDto);
    DoctorResponseDto doctorToDoctorResponseDto(Doctor doctor);
}


