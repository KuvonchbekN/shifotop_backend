package uz.shifotop.api.doctor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.shifotop.api.doctor.dto.DoctorCreateDto;
import uz.shifotop.api.doctor.dto.DoctorResponseDto;
import uz.shifotop.api.doctor.dto.DoctorSpecialityCountDto;
import uz.shifotop.api.doctor.entity.Doctor;
import uz.shifotop.api.doctor.mapper.DoctorMapper;
import uz.shifotop.api.doctor.repository.DoctorRepository;
import uz.shifotop.api.specialization.entity.Specialities;
import uz.shifotop.api.specialization.repository.SpecialitiesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;
    private final SpecialitiesRepository specialitiesRepository;

    public List<DoctorResponseDto> getAllDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList.stream().map(doctorMapper::doctorToDoctorResponseDto).toList();
    }

    public DoctorResponseDto createDoctor(DoctorCreateDto dto) {
        Doctor doctor = doctorMapper.doctorCreateDtoToDoctor(dto);
        doctorRepository.save(doctor);
        return doctorMapper.doctorToDoctorResponseDto(doctor);
    }

    public DoctorResponseDto getDoctor(long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        return doctorMapper.doctorToDoctorResponseDto(doctor);
    }

    public List<DoctorResponseDto> getDoctorsBySpeciality(Long specId, Integer page, Integer size) {

        Pageable pageRequest = PageRequest.of(page, size);
        List<Doctor> doctors = doctorRepository.findAll(pageRequest).toList();

        return doctors.stream()
                .map(doctorMapper::doctorToDoctorResponseDto)
                .collect(Collectors.toList());
    }

    public List<DoctorSpecialityCountDto> getDoctorsSpecialitiesWithCount()
    {
        //get speciality name and count of doctors attached to that speciality
        List<DoctorSpecialityCountDto> result = new ArrayList<>();
        List<Specialities> allSpecialities = specialitiesRepository.findAll();
        for(int i=0; i<4; i++){
            Specialities specialities = allSpecialities.get(i);
            DoctorSpecialityCountDto doctorSpecialityCountDto = new DoctorSpecialityCountDto(specialities.getName(), specialities.getDoctors().size());
            result.add(doctorSpecialityCountDto);
        }
        return result;
    }

    public Long getDoctorsCount()
    {
        return doctorRepository.count();
    }
}
