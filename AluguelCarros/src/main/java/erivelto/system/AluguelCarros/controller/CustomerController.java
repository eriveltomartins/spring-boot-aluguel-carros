package erivelto.system.AluguelCarros.controller;

import erivelto.system.AluguelCarros.dto.CarDTO;
import erivelto.system.AluguelCarros.dto.CustomerDTO;
import erivelto.system.AluguelCarros.model.Customer;
import erivelto.system.AluguelCarros.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody CustomerDTO data, UriComponentsBuilder uriBuilder){
        var currentCustomer = new Customer(data);
        service.saveCustomer(currentCustomer);

        var uri = uriBuilder.path("/car/{id}").buildAndExpand(currentCustomer.getId()).toUri();

        return ResponseEntity.created(uri).body(currentCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        var currentCustomer = service.searchCustomerWithId(id);

        return ResponseEntity.ok(currentCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CustomerDTO dto, @PathVariable Long id){
        var currentCustomer = service.updateCustomer(dto, id);

        return ResponseEntity.ok(currentCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }
}
