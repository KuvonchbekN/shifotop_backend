package uz.shifotop.api.service.mapper;

import org.springframework.stereotype.Component;
import uz.shifotop.api.service.dto.MedicalServiceRequestDto;
import uz.shifotop.api.service.dto.MedicalServiceResponseDto;
import uz.shifotop.api.service.entity.MedicalService;

@Component
public interface MedServiceMapper {

    MedicalService serviceDtoToService(MedicalServiceRequestDto medicalServiceRequestDto);

    MedicalServiceResponseDto serviceToServiceDto(MedicalService medicalService);
}
