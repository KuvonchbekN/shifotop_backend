package uz.shifotop.api.address.service;

import org.springframework.stereotype.Service;
import uz.shifotop.api.address.dto.AddressRequestDto;
import uz.shifotop.api.address.entity.Address;

import java.util.List;

@Service
public interface AddressService {
    Address getAddressById(Long addressId);
    
    Address getOrientalPlaceById(Long orientId);

    void removeOrientalPlaceById(Long orientId);

    List<Address> getAllAddresses();

    Long saveAddress(AddressRequestDto addressRequestDto);
}
