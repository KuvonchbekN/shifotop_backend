package uz.shifotop.api.clinic.mapper;

import org.springframework.stereotype.Component;
import uz.shifotop.api.address.dto.AddressResponseDto;
import uz.shifotop.api.address.entity.Address;
import uz.shifotop.api.clinic.dto.ClinicRequestDto;
import uz.shifotop.api.clinic.dto.ClinicResponseDto;
import uz.shifotop.api.clinic.dto.MedicalServiceResponseDto;
import uz.shifotop.api.clinic.entity.Clinic;
import uz.shifotop.api.clinic.entity.MedicalService;
import uz.shifotop.api.clinicSpecs.dto.ClinicSpecsRequestDto;
import uz.shifotop.api.clinicSpecs.dto.ClinicSpecsResponseDto;
import uz.shifotop.api.clinicSpecs.entity.ClinicSpec;
import uz.shifotop.api.doctor.dto.DoctorResponseDto;
import uz.shifotop.api.doctor.entity.Doctor;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClinicMapperImpl implements ClinicMapper {
    @Override
    public Clinic clinicDtoToClinic(ClinicRequestDto clinicRequestDto, Clinic clinicToBeUpdated) {
        if (clinicRequestDto != null && clinicToBeUpdated != null) {
            if (clinicRequestDto.name() != null) {
                clinicToBeUpdated.setName(clinicRequestDto.name());
            }
            if (clinicRequestDto.officialName() != null) {
                clinicToBeUpdated.setOfficialName(clinicRequestDto.officialName());
            }
            if (clinicRequestDto.phoneNumber() != null) {
                clinicToBeUpdated.setPhoneNumber(clinicRequestDto.phoneNumber());
            }
            if (clinicRequestDto.supervisorName() != null) {
                clinicToBeUpdated.setSupervisorName(clinicRequestDto.supervisorName());
            }
        }
        return clinicToBeUpdated;
    }


    @Override
    public List<ClinicResponseDto> clinicListToClinicResponseDtoList(List<Clinic> clinics) {
        if (clinics == null) {
            return new ArrayList<>();
        }

        return clinics.stream().map(clinic -> {
            ClinicResponseDto dto = new ClinicResponseDto();
            dto.setId(clinic.getId());
            dto.setName(clinic.getName());
            dto.setOfficialName(clinic.getOfficialName());
            dto.setPhoneNumber(clinic.getPhoneNumber());
            dto.setSupervisorName(clinic.getSupervisorName());
            dto.setDoctors(mapDoctors(clinic.getDoctors()));
            dto.setMedicalServices(mapMedicalServices(clinic.getMedicalServices()));
            dto.setAddress(mapAddress(clinic.getAddress()));
            dto.setOrientalPlaces(mapOrientalPlaces(clinic.getOrientalPlaces()));
            dto.setClinicSpecs(mapClinicSpecs(clinic.getClinicSpecs()));
            return dto;
        }).collect(Collectors.toList());    }

    private List<DoctorResponseDto> mapDoctors(Set<Doctor> doctors) {
        // Transform doctors set to DoctorResponseDto list
        return doctors.stream().map(doctor -> new DoctorResponseDto(doctor.getId(),
                doctor.getFirstname(),
                doctor.getLastname(),
                doctor.getPhoneNumber(),
                doctor.getBio(),
                Year.now().getValue() - doctor.getCareerStartYear(),
                doctor.getPrice(),
                null,
                null,
                null,
                0))
                .collect(Collectors.toList());
    }

    private List<MedicalServiceResponseDto> mapMedicalServices(List<MedicalService> medicalServices) {
        // Transform medical services to MedicalServiceResponseDto list
        return medicalServices.stream().map(service -> new MedicalServiceResponseDto(service.getId(), service.getName(), service.getCost())).collect(Collectors.toList());
    }

    private AddressResponseDto mapAddress(Address address) {
        // Transform Address to AddressResponseDto
        return new AddressResponseDto(address.getRegionName(), address.getCityName(), address.getAddressName());
    }

    private List<AddressResponseDto> mapOrientalPlaces(List<Address> orientalPlaces) {
        // Transform list of Address to list of AddressResponseDto
        return orientalPlaces.stream().map(place -> new AddressResponseDto(place.getRegionName(),
                        place.getCityName(),
                        place.getAddressName()))
                .collect(Collectors.toList());
    }

    private List<ClinicSpecsResponseDto> mapClinicSpecs(Set<ClinicSpec> clinicSpecs) {
        // Transform set of ClinicSpec to ClinicSpecsResponseDto list
        return clinicSpecs.stream().map(spec -> new ClinicSpecsResponseDto(spec.getId(), spec.getName())).collect(Collectors.toList());
    }

    @Override
    public ClinicResponseDto clinicToClinicResponseDto(Clinic clinic, ClinicResponseDto clinicResponseDto) {
        clinicResponseDto.setId(clinic.getId());
        clinicResponseDto.setName(clinic.getName());
        clinicResponseDto.setOfficialName(clinic.getOfficialName());
        clinicResponseDto.setPhoneNumber(clinic.getPhoneNumber());
        clinicResponseDto.setSupervisorName(clinic.getSupervisorName());
        return clinicResponseDto;
    }

    @Override
    public Clinic clinicSpecsDtoToClinic(ClinicSpecsRequestDto clinicSpecsRequestDto, Clinic clinic) {
        clinic.setName(clinicSpecsRequestDto.name());
        clinic.setOfficialName(clinicSpecsRequestDto.officialName());
        clinic.setPhoneNumber(clinicSpecsRequestDto.phoneNumber());
        clinic.setSupervisorName(clinicSpecsRequestDto.supervisorName());
        return clinic;
    }
}
