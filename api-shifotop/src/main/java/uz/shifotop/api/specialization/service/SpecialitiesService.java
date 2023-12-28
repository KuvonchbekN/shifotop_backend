package uz.shifotop.api.specialization.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.shifotop.api.common.exception.BadRequestException;
import uz.shifotop.api.specialization.dto.SpecialityCreateDto;
import uz.shifotop.api.specialization.dto.SpecialityResponseDto;
import uz.shifotop.api.specialization.entity.Specialities;
import uz.shifotop.api.specialization.mapper.SpecialityMapper;
import uz.shifotop.api.specialization.repository.SpecialitiesRepository;

@Service
@RequiredArgsConstructor
public class SpecialitiesService {

    private final SpecialitiesRepository specsRepository;
    private final SpecialityMapper specialityMapper;

    public SpecialityResponseDto addSpeciality(SpecialityCreateDto createDto) {
        boolean exists = specsRepository.existsByName(createDto.name());

        if(exists){
            throw new BadRequestException(String.format("speciality with name %s exists", createDto.name()));
        }

        Specialities specialities = specialityMapper.specsCreateDtoToSpecs(createDto);
        specsRepository.save(specialities);
        return specialityMapper.specsToSpecsResponseDto(specialities);
    }
}
