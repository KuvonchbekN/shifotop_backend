package uz.shifotop.api.clinicSpecs.service.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import uz.shifotop.api.clinic.service.ClinicService;
import uz.shifotop.api.clinicSpecs.dto.ClinicSpecCreateDto;
import uz.shifotop.api.clinicSpecs.entity.ClinicSpec;
import uz.shifotop.api.clinicSpecs.mapper.ClinicSpecsMapper;
import uz.shifotop.api.clinicSpecs.repository.ClinicSpecsRepo;
import uz.shifotop.api.clinicSpecs.service.ClinicSpecsService;
import uz.shifotop.api.common.exception.BadRequestException;
import uz.shifotop.api.common.exception.ExceptionMessages;
import uz.shifotop.api.common.exception.NotFoundException;

import java.util.List;

@Service
public class ClinicSpecsServiceImpl implements ClinicSpecsService {

    private final ClinicSpecsRepo clinicSpecsRepo;
    private final ClinicSpecsMapper clinicSpecsMapper;

    private final ClinicService clinicService;

    public ClinicSpecsServiceImpl(ClinicSpecsRepo clinicSpecsRepo, ClinicSpecsMapper clinicSpecsMapper, @Lazy ClinicService clinicService) {
        this.clinicSpecsRepo = clinicSpecsRepo;
        this.clinicSpecsMapper = clinicSpecsMapper;
        this.clinicService = clinicService;
    }

    @Override
    public List<ClinicSpec> getClinicSpecsByClinicId(Long clinicId) {
        clinicService.getClinicById(clinicId);//throws exception if clinic is not found
        return clinicSpecsRepo.findAllByClinicsId(clinicId);
    }

    @Override
    public List<ClinicSpec> getClinicSpecsByIds(List<Long> specs) {
        List<ClinicSpec> allById = clinicSpecsRepo.findAllById(specs);
        if (allById.isEmpty()){
            throw new NotFoundException(ExceptionMessages.CLINIC_SPEC_NOT_FOUND);
        }
        return allById;
    }

    @Override
    public Long createClinicSpec(ClinicSpecCreateDto clinicSpecCreateDto) {
        boolean exists = clinicSpecsRepo.existsByName(clinicSpecCreateDto.name());
        if (exists){
            throw new BadRequestException(ExceptionMessages.CLINIC_SPEC_NAME_ALREADY_EXIST);
        }

        ClinicSpec clinicSpec = clinicSpecsMapper.fromClinicSpecCreateDtoToClinicSpec(clinicSpecCreateDto);
        clinicSpecsRepo.save(clinicSpec);
        return clinicSpec.getId();
    }

    @Override
    public List<ClinicSpec> getClinicSpecsList() { //todo: need to add pagination, sorting later
        return clinicSpecsRepo.findAll();
    }
}
