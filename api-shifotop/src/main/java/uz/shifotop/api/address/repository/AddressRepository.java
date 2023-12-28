package uz.shifotop.api.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.shifotop.api.address.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
