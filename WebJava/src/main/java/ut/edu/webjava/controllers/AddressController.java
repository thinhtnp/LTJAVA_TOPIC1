package ut.edu.webjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ut.edu.webjava.models.Address;
import ut.edu.webjava.services.AddressService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/user/{userId}")
    public List<Address> getAddressesByUserId(@PathVariable Long userId) {
        return addressService.getAddressesByUserId(userId);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Optional<Address> address = addressService.getAddressById(id);
        return address.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
