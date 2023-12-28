package uz.shifotop.api.clinic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.shifotop.api.clinic.dto.ClinicRequestDto;
import uz.shifotop.api.clinic.dto.ClinicResponseDto;
import uz.shifotop.api.clinic.entity.Clinic;
import uz.shifotop.api.clinicSpecs.dto.ClinicSpecsRequestDto;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClinicMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "doctors", ignore = true)
    @Mapping(target = "medicalServices", ignore = true)
    @Mapping(target = "orientalPlaces", ignore = true)
    @Mapping(target = "users", ignore = true)
    Clinic clinicDtoToClinic(ClinicRequestDto clinicUpdateRequestDto, @MappingTarget Clinic clinicTobeUpdated);


    List<ClinicResponseDto> clinicListToClinicResponseDtoList(List<Clinic> clinics);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "doctors", ignore = true)
    @Mapping(target = "medicalServices", ignore = true)
    @Mapping(target = "orientalPlaces", ignore = true)
    @Mapping(target = "users", ignore = true)
    Clinic clinicSpecsDtoToClinic(ClinicSpecsRequestDto clinicSpecsRequestDto, @MappingTarget Clinic clinic);
}

