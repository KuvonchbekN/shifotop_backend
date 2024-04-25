package uz.shifotop.api.search.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.shifotop.api.clinic.dto.ClinicResponseDto;
import uz.shifotop.api.clinic.entity.Clinic;
import uz.shifotop.api.clinic.entity.MedicalService;
import uz.shifotop.api.clinic.repository.ClinicRepo;
import uz.shifotop.api.clinic.repository.MedicalServiceRepo;
import uz.shifotop.api.clinic.service.ClinicService;
import uz.shifotop.api.doctor.dto.DoctorResponseDto;
import uz.shifotop.api.doctor.entity.Doctor;
import uz.shifotop.api.doctor.repository.DoctorRepository;
import uz.shifotop.api.doctor.service.DoctorService;
import uz.shifotop.api.search.dto.SearchResultsDto;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final DoctorRepository doctorRepository;
    private final ClinicRepo clinicRepository; //todo: make the names consistent, repo != repository
    private final MedicalServiceRepo serviceRepository;
    private final DoctorService doctorService; //todo: make it consistent with clinic service layer, for doctor there is not interface
    private final ClinicService clinicService;

    public SearchResultsDto search(String query) {
        List<Doctor> doctors = new ArrayList<Doctor>();
        List<Doctor> doctorsByFirstName = doctorRepository.findByFirstnameContainingIgnoreCase(query);
        List<Doctor> doctorsByLastName = doctorRepository.findByLastnameContainingIgnoreCase(query);
        if (doctorsByFirstName!=null && !doctorsByFirstName.isEmpty()) {
            doctors.addAll(doctorsByFirstName);
        }
        if (doctorsByLastName!=null && !doctorsByLastName.isEmpty()) {
            doctors.addAll(doctorsByLastName);
        }
        List<Clinic> clinics = clinicRepository.findByNameContainingIgnoreCase(query);
        List<MedicalService> services = serviceRepository.findByNameContainingIgnoreCase(query);
        //convert from entity list to dto list;

        List<DoctorResponseDto> doctorResponseDtoList = doctorService.getDoctorResponseDtoListFromDoctorsList(doctors);
        //the same for clinic and services
        List<ClinicResponseDto> clinicResponseDtoList = clinicService.getClinicResponseDtoListFromClinicList(clinics);


        return new SearchResultsDto(doctorResponseDtoList, clinicResponseDtoList, null);
    }


}
