package uz.shifotop.api.clinicSpecs.service;

import uz.shifotop.api.clinicSpecs.dto.ClinicSpecCreateDto;
import uz.shifotop.api.clinicSpecs.entity.ClinicSpec;

import java.util.List;


public interface ClinicSpecsService {

    List<ClinicSpec> getClinicSpecsByClinicId(Long clinicId);

    List<ClinicSpec> getClinicSpecsByIds(List<Long> specs);

    Long createClinicSpec(ClinicSpecCreateDto clinicSpecCreateDto);

    List<ClinicSpec> getClinicSpecsList();
}
