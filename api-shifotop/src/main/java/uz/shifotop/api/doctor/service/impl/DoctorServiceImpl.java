package uz.shifotop.api.doctor.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.shifotop.api.clinic.entity.Clinic;
import uz.shifotop.api.clinic.service.ClinicService;
import uz.shifotop.api.doctor.mapper.DoctorMapper;
import uz.shifotop.api.user.dto.UserCreateDto;
import uz.shifotop.api.user.entity.User;
import uz.shifotop.api.user.repository.UserRepository;
import uz.shifotop.api.user.service.UserService;

import java.util.Set;

@RequiredArgsConstructor
@Service
@Transactional
public class DoctorServiceImpl implements UserService
{

	private final UserRepository userRepository;
	private final ClinicService clinicService;
	private final DoctorMapper doctorMapper;


	@Override
	public Long createUser(UserCreateDto userCreateDto)
	{
		User user = doctorMapper.userCreateDtoToUser(userCreateDto);
		Set<Clinic> allClinicsByClinicIds = clinicService.findAllClinicsByClinicIds(userCreateDto.clinicIds());//here we don't have clinics yet
		user.setClinics(allClinicsByClinicIds);
		userRepository.save(user);
		return user.getId();
	}
}
