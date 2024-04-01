package uz.shifotop.api.clinic.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.shifotop.api.address.entity.Address;
import uz.shifotop.api.address.service.AddressService;
import uz.shifotop.api.clinic.dto.*;
import uz.shifotop.api.clinic.entity.Clinic;
import uz.shifotop.api.clinic.entity.MedicalService;
import uz.shifotop.api.clinic.mapper.ClinicMapper;
import uz.shifotop.api.clinic.repository.ClinicRepo;
import uz.shifotop.api.clinic.service.ClinicService;
import uz.shifotop.api.clinic.service.MedicalServiceService;
import uz.shifotop.api.clinicSpecs.dto.ClinicSpecsRequestDto;
import uz.shifotop.api.clinicSpecs.entity.ClinicSpec;
import uz.shifotop.api.clinicSpecs.repository.ClinicSpecsRepo;
import uz.shifotop.api.clinicSpecs.service.ClinicSpecsService;
import uz.shifotop.api.common.exception.NotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClinicServiceImpl implements ClinicService {

    private final ClinicRepo clinicRepository;
    private final ClinicMapper clinicMapper;
    private final MedicalServiceService medicalServiceService;
    private final AddressService addressService;
    @Lazy
    private final ClinicSpecsService clinicSpecsService;
    private final ClinicSpecsRepo clinicSpecsRepo;


    @Override
    public List<ClinicResponseDto> getAllClinics(PageSettings pageSetting) {
        if (pageSetting.getKey() == null) {
            pageSetting.setKey("name");
        }

        Sort clinicSort = pageSetting.buildSort();
        Pageable clinicPage = PageRequest.of(pageSetting.getPage(), pageSetting.getPageSize(), clinicSort);
        Page<Clinic> all = clinicRepository.findAll(clinicPage);
        List<Clinic> content = all.getContent();
        return clinicMapper.clinicListToClinicResponseDtoList(content);
    }

    public Clinic getClinicById(Long id) {
        return clinicRepository.findById(id).orElseThrow(() -> new NotFoundException("Could not find the clinic with this id!"));
    }

    public Long createClinic(ClinicRequestDto clinicDto) {
        Clinic clinic = clinicMapper.clinicDtoToClinic(clinicDto, new Clinic());
        Clinic savedClinic = clinicRepository.save(clinic);
        return savedClinic.getId();
    }

    @Override
    public Long createClinicWithSpecs(ClinicSpecsRequestDto clinicSpecsRequestDto) {
        List<ClinicSpec> clinicSpecsByIds = clinicSpecsService.getClinicSpecsByIds(clinicSpecsRequestDto.specsIds());//it will throw exception if the spec id is not found

        Clinic clinic = clinicMapper.clinicSpecsDtoToClinic(clinicSpecsRequestDto, new Clinic());
        clinic.setClinicSpecs(new HashSet<>(clinicSpecsByIds));
        Clinic savedClinic = clinicRepository.save(clinic);
        return savedClinic.getId();
    }

    @Override
    public List<ClinicCountDto> getClinicsSpecialitiesWithCount()
    {
        List<ClinicSpec> allClinicSpecs = clinicSpecsRepo.findAll();
        List<ClinicCountDto> result = new ArrayList<>();

        for(int i=0; i<4; i++){
            var current = allClinicSpecs.get(i);
            ClinicCountDto dto = new ClinicCountDto(current.getName(), current.getClinics().size());
            result.add(dto);
        }
        return result;
    }

    @Override
    public Long getAllClinicsCount()
    {
        return clinicRepository.count();
    }

    @Override
    public List<ClinicCountDto> getClinicsByServices()
    {
        List<MedicalService> all = medicalServiceService.getAllMedicalServices();
        var result = new ArrayList<ClinicCountDto>();
        for(int i=0; i<4; i++){
            MedicalService curr = all.get(i);
            ClinicCountDto clinicCountDto = new ClinicCountDto(curr.getName(), 1); //todo research : maybe clinic -> services is not one-to-many, but many-to-many
            result.add(clinicCountDto);
        }

        return result;
    }


    public Long updateClinic(Long clinicId, ClinicRequestDto clinicUpdateRequestDto) {
        Clinic clinicTobeUpdated = getClinicById(clinicId);
        Clinic updatedClinic = clinicMapper.clinicDtoToClinic(clinicUpdateRequestDto, clinicTobeUpdated);
        return clinicRepository.save(updatedClinic).getId();
    }

    @Override
    public void assignMedicalService(MedicalServiceRequestDto medicalServiceDto) {
        Clinic clinic = getClinicById(medicalServiceDto.clinicId());
        MedicalService medicalService = medicalServiceService.getMedicalServiceById(medicalServiceDto.medServiceId());
        clinic.addMedicalService(medicalService);
        clinicRepository.save(clinic);
    }

    @Override
    public void removeMedicalService(Long clinicId, Long serviceId) {
        Clinic clinic = getClinicById(clinicId);
        MedicalService medicalService = medicalServiceService.getMedicalServiceById(serviceId);
        clinic.removeMedicalService(medicalService);
        medicalServiceService.removeMedicalService(serviceId);
    }

    @Override
    public void assignOrient(OrientalPlaceDto orientalPlaceDto) {
        Clinic clinicById = getClinicById(orientalPlaceDto.clinicId());
        Address orientalPlaceById = addressService.getOrientalPlaceById(orientalPlaceDto.orientId());
        clinicById.addOrientalPlace(orientalPlaceById);
        clinicRepository.save(clinicById);
    }

    @Override
    public void removeOrient(Long clinicId, Long orientId) {
        Address addressById = addressService.getOrientalPlaceById(orientId);
        Clinic clinicById = getClinicById(clinicId);
        clinicById.removeOrientalPlace(addressById);
        addressService.removeOrientalPlaceById(orientId);
    }

    @Override
    public Set<Clinic> findAllClinicsByClinicIds(List<Long> clinicIds) {
        return clinicRepository.findAllByIdIn(clinicIds);
    }

}
