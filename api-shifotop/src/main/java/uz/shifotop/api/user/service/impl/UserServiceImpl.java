package uz.shifotop.api.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.shifotop.api.user.mapper.UserMapper;
import uz.shifotop.api.user.entity.User;
import uz.shifotop.api.user.dto.UserCreateDto;
import uz.shifotop.api.user.repository.UserRepository;
import uz.shifotop.api.user.service.UserService;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Long createUser(UserCreateDto userCreateDto) {
        User user = userMapper.userCreateDtoToPatient(userCreateDto);
        userRepository.save(user);
        return user.getId();
    }
}
