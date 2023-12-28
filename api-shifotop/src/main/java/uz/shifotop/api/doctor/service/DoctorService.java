package uz.shifotop.api.doctor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.shifotop.api.doctor.dto.DoctorCreateDto;
import uz.shifotop.api.doctor.dto.DoctorResponseDto;
import uz.shifotop.api.doctor.entity.Doctor;
import uz.shifotop.api.doctor.mapper.DoctorMapper;
import uz.shifotop.api.doctor.repository.DoctorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;

    public List<DoctorResponseDto> getAllDoctors() {
        return null;
    }

    public DoctorResponseDto createDoctor(DoctorCreateDto dto) {
        Doctor doctor = doctorMapper.doctorCreateDtoToDoctor(dto);
        doctorRepository.save(doctor);
        DoctorResponseDto responseDto = doctorMapper.doctorToDoctorResponseDto(doctor);
        return responseDto;
    }

    public DoctorResponseDto getDoctor(long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        return doctorMapper.doctorToDoctorResponseDto(doctor);
    }

    public List<DoctorResponseDto> getDoctorsBySpeciality(Long specId, Integer page, Integer size) {

        Pageable pageRequest = PageRequest.of(page, size);
        List<Doctor> doctors = doctorRepository.findAll(pageRequest).toList();

        List<DoctorResponseDto> responseDtos = doctors.stream()
                .map(doctorMapper::doctorToDoctorResponseDto)
                .collect(Collectors.toList());
        return responseDtos;
    }
}
