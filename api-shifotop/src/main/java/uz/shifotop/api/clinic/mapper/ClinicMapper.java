package uz.shifotop.api.clinic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.shifotop.api.address.dto.AddressResponseDto;
import uz.shifotop.api.address.entity.Address;
import uz.shifotop.api.clinic.dto.ClinicRequestDto;
import uz.shifotop.api.clinic.dto.ClinicResponseDto;
import uz.shifotop.api.clinic.entity.Clinic;
import uz.shifotop.api.clinicSpecs.dto.ClinicSpecsRequestDto;

import java.util.List;

@Component
public interface ClinicMapper {


    Clinic clinicDtoToClinic(ClinicRequestDto clinicUpdateRequestDto, @MappingTarget Clinic clinicTobeUpdated);


    List<ClinicResponseDto> clinicListToClinicResponseDtoList(List<Clinic> clinics);


    ClinicResponseDto clinicToClinicResponseDto(Clinic clinic, @MappingTarget ClinicResponseDto clinicResponseDto);

    Clinic clinicSpecsDtoToClinic(ClinicSpecsRequestDto clinicSpecsRequestDto, @MappingTarget Clinic clinic);
}

