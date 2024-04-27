package uz.shifotop.api.service.service;

import org.springframework.stereotype.Service;
import uz.shifotop.api.service.dto.MedicalServiceResponseDto;
import uz.shifotop.api.service.entity.MedicalService;

import java.util.List;

@Service
public interface MedicalServiceService {
    MedicalServiceResponseDto getMedicalServiceById(Long id);

    void removeMedicalService(Long serviceId);

    Long getMedicalServicesCount();

    List<MedicalService> getAllMedicalServices();

    List<MedicalService> getAllMedicalServicesByName(String type);

    List<MedicalServiceResponseDto> getServiceResponseDtoListFromServiceList(List<MedicalService> serviceList);
}
