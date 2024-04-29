package uz.shifotop.api.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.shifotop.api.service.dto.MedicalServiceResponseDto;
import uz.shifotop.api.service.entity.MedicalService;
import uz.shifotop.api.service.mapper.MedServiceMapper;
import uz.shifotop.api.service.mapper.MedServiceMapperImpl;
import uz.shifotop.api.service.repository.MedicalServiceRepo;
import uz.shifotop.api.common.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MedicalServiceServiceImpl implements MedicalServiceService {
    private final MedicalServiceRepo medicalServiceRepo;
    private final MedServiceMapper medServiceMapper;


    @Override
    public MedicalServiceResponseDto getMedicalServiceById(Long id) {
        MedicalService medicalService = medicalServiceRepo.findById(id).orElseThrow(() -> new NotFoundException("Service with this id is not found!"));
        return medServiceMapper.serviceToServiceDto(medicalService);
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

    @Override
    public List<MedicalService> getAllMedicalServicesByName(String name) {
        return medicalServiceRepo.findByNameContainingIgnoreCase(name);
    }

    public List<MedicalServiceResponseDto> getServiceResponseDtoListFromServiceList(List<MedicalService> serviceList) {
        List<MedicalServiceResponseDto> serviceResponseDtoList = new ArrayList<>();
        for (var medicalService : serviceList) {
            serviceResponseDtoList.add(medServiceMapper.serviceToServiceDto(medicalService));
        }

        return serviceResponseDtoList;
    }
}
