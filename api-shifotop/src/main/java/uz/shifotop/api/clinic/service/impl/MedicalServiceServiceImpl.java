package uz.shifotop.api.clinic.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.shifotop.api.clinic.entity.MedicalService;
import uz.shifotop.api.clinic.repository.MedicalServiceRepo;
import uz.shifotop.api.clinic.service.MedicalServiceService;
import uz.shifotop.api.common.exception.NotFoundException;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MedicalServiceServiceImpl implements MedicalServiceService {
    private final MedicalServiceRepo medicalServiceRepo;


    @Override
    public MedicalService getMedicalServiceById(Long id) {
        return medicalServiceRepo.findById(id).orElseThrow(() -> new NotFoundException("Service with this id is not found!"));
    }

    @Override
    public void removeMedicalService(Long serviceId) {
        medicalServiceRepo.deleteById(serviceId);
    }

    @Override
    public Long getMedicalServicesCount()
    {
        return medicalServiceRepo.count();
    }

    @Override
    public List<MedicalService> getAllMedicalServices()
    {
        return medicalServiceRepo.findAll();
    }
}
