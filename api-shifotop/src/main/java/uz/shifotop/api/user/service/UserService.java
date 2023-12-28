package uz.shifotop.api.user.service;

import org.springframework.stereotype.Service;
import uz.shifotop.api.user.dto.UserCreateDto;

@Service
public interface UserService {

    Long createUser(UserCreateDto userCreateDto);
}
