package uz.shifotop.api.clinic.service;

import org.springframework.stereotype.Component;
import uz.shifotop.api.clinic.dto.*;
import uz.shifotop.api.clinic.entity.Clinic;
import uz.shifotop.api.clinicSpecs.dto.ClinicSpecsRequestDto;

import java.util.List;
import java.util.Set;


@Component
public interface ClinicService {
    List<ClinicResponseDto> getAllClinics(PageSettings pageSettings);

    Set<Clinic> findAllClinicsByClinicIds(List<Long> clinicIds);

    ClinicResponseDto getClinicById(Long id);

    Long createClinic(ClinicRequestDto clinic);

//    Long updateClinic(Long id, ClinicRequestDto clinic);

//    void assignMedicalService(MedicalServiceRequestDto medicalService);

//    void removeMedicalService(Long clinicId, Long serviceId);

//    void assignOrient(OrientalPlaceDto orientalPlaceDto);


//    void removeOrient(Long clinicId, Long orientId);

    Long createClinicWithSpecs(ClinicSpecsRequestDto clinicSpecsRequestDto);

    List<ClinicCountDto> getClinicsSpecialitiesWithCount();

    Long getAllClinicsCount();

    List<ClinicCountDto> getClinicsByServices();
}
