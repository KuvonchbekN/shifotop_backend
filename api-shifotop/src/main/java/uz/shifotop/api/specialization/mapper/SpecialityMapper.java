package uz.shifotop.api.specialization.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.shifotop.api.specialization.dto.SpecialityCreateDto;
import uz.shifotop.api.specialization.dto.SpecialityResponseDto;
import uz.shifotop.api.specialization.entity.Specialities;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SpecialityMapper {

    Specialities specsCreateDtoToSpecs(SpecialityCreateDto createDto);
    SpecialityResponseDto specsToSpecsResponseDto(Specialities specialities);

}
