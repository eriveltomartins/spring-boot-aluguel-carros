package erivelto.system.AluguelCarros.service;

import erivelto.system.AluguelCarros.dto.CustomerDTO;
import erivelto.system.AluguelCarros.exceptions.NotFoundIdException;
import erivelto.system.AluguelCarros.model.Customer;
import erivelto.system.AluguelCarros.repository.CustomerRepository;
import erivelto.system.AluguelCarros.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RentalRepository rentalRepository;


    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Customer searchCustomerWithId(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundIdException("No records found for this id"));
    }

    public Customer updateCustomer(CustomerDTO data, Long id){
        var customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundIdException("No records found for this id"));

        customer.setName(data.name());
        customer.setEmail(data.email());

        customerRepository.save(customer);

        return customer;

    }

    public void deleteCustomerById(Long id){
        customerRepository.findById(id).orElseThrow(() -> new NotFoundIdException("No records found for this id"));

        rentalRepository.deleteByCustomerId(id);
        customerRepository.deleteById(id);
    }
}
