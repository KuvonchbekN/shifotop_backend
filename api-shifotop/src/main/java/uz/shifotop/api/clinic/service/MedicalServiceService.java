package uz.shifotop.api.clinic.service;

import org.springframework.stereotype.Service;
import uz.shifotop.api.clinic.entity.MedicalService;

@Service
public interface MedicalServiceService {
    MedicalService getMedicalServiceById(Long id);

    void removeMedicalService(Long serviceId);
}
