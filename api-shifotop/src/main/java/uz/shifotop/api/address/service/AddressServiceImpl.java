package uz.shifotop.api.address.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.shifotop.api.address.dto.AddressRequestDto;
import uz.shifotop.api.address.entity.Address;
import uz.shifotop.api.address.mapper.AddressMapper;
import uz.shifotop.api.address.repository.AddressRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;


    public Address getAddressById(Long addressId){
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("address with this id is not found!")); //todo later do custom runtime exception
    }

    @Override
    public Address getOrientalPlaceById(Long orientId) {
        return getAddressById(orientId);
    }

    public void removeOrientalPlaceById(Long orientId) {
        addressRepository.deleteById(orientId);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Long saveAddress(AddressRequestDto addressRequestDto) {
        Address address = addressMapper.addressRequestDtoToAddress(addressRequestDto);
        Address savedAddress = addressRepository.save(address);
        return savedAddress.getId();
    }
}


