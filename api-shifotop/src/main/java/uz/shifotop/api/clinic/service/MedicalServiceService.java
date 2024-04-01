package uz.shifotop.api.clinic.service;

import org.springframework.stereotype.Service;
import uz.shifotop.api.clinic.entity.MedicalService;

import java.util.List;

@Service
public interface MedicalServiceService {
    MedicalService getMedicalServiceById(Long id);

    void removeMedicalService(Long serviceId);

    Long getMedicalServicesCount();

    List<MedicalService> getAllMedicalServices();
}
