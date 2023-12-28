package uz.shifotop.api.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.shifotop.api.user.entity.User;
import uz.shifotop.api.user.dto.UserCreateDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "clinics", ignore = true)
    User userCreateDtoToPatient(UserCreateDto userCreateDto);
}
