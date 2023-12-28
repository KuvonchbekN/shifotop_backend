package uz.shifotop.api.clinicSpecs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.shifotop.api.clinicSpecs.dto.ClinicSpecCreateDto;
import uz.shifotop.api.clinicSpecs.entity.ClinicSpec;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClinicSpecsMapper {

    ClinicSpec fromClinicSpecCreateDtoToClinicSpec(ClinicSpecCreateDto clinicSpecCreateDto);
}
