package ut.edu.webjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ut.edu.webjava.models.Address;
import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByUserId(Long userId);
}
