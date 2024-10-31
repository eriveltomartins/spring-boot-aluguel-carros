package erivelto.system.AluguelCarros.service;

import erivelto.system.AluguelCarros.dto.CustomerDTO;
import erivelto.system.AluguelCarros.model.Customer;
import erivelto.system.AluguelCarros.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Customer searchCustomerWithId(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    public Customer updateCustomer(CustomerDTO data, Long id){
        var customer = customerRepository.findById(id).orElse(null);

        customer.setName(data.name());
        customer.setEmail(data.email());

        customerRepository.save(customer);

        return customer;

    }

    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }
}
