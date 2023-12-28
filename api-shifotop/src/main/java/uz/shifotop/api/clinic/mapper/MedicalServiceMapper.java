package uz.shifotop.api.clinic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.shifotop.api.clinic.dto.ClinicRequestDto;
import uz.shifotop.api.clinic.dto.MedicalServiceRequestDto;
import uz.shifotop.api.clinic.entity.Clinic;
import uz.shifotop.api.clinic.entity.MedicalService;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MedicalServiceMapper {

    @Mapping(target = "clinic", ignore = true)
    @Mapping(target = "id", ignore = true)
    MedicalService serviceDtoToService(MedicalServiceRequestDto medicalServiceRequestDto);
}
