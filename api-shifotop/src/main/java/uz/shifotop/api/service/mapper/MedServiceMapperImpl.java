package uz.shifotop.api.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import uz.shifotop.api.clinic.dto.ClinicResponseDto;
import uz.shifotop.api.clinic.entity.Clinic;
import uz.shifotop.api.clinic.service.ClinicService;
import uz.shifotop.api.service.dto.MedicalServiceRequestDto;
import uz.shifotop.api.service.dto.MedicalServiceResponseDto;
import uz.shifotop.api.service.entity.MedicalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class MedServiceMapperImpl implements MedServiceMapper {

    @Lazy
    private final ClinicService clinicService;

    @Override
    public MedicalService serviceDtoToService(MedicalServiceRequestDto medicalServiceRequestDto) {
        return null;
    }

    @Override
    public MedicalServiceResponseDto serviceToServiceDto(MedicalService medicalService) {
        var medicalServiceResponseDto = new MedicalServiceResponseDto();
        Set<Clinic> clinics = medicalService.getClinics();
        List<ClinicResponseDto> clinicResponseDtos = new ArrayList<>();
        for (var clinic : clinics) {
            ClinicResponseDto clinicResponseDto = clinicService.getClinicById(clinic.getId());
            clinicResponseDtos.add(clinicResponseDto);
        }
        medicalServiceResponseDto.setId(medicalService.getId());
        medicalServiceResponseDto.setName(medicalService.getName());
        medicalServiceResponseDto.setCost(medicalService.getCost());

        medicalServiceResponseDto.setClinics(clinicResponseDtos);
        return medicalServiceResponseDto;
    }
}
