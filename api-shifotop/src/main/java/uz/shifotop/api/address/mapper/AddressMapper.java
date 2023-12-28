package uz.shifotop.api.address.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.shifotop.api.address.dto.AddressRequestDto;
import uz.shifotop.api.address.entity.Address;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {

    Address addressRequestDtoToAddress(AddressRequestDto addressRequestDto);
}
