package erivelto.system.AluguelCarros.service;

import erivelto.system.AluguelCarros.dto.RentalDTO;
import erivelto.system.AluguelCarros.exceptions.NotFoundIdException;
import erivelto.system.AluguelCarros.repository.CustomerRepository;
import erivelto.system.AluguelCarros.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Page<RentalDTO> getRentalsByIdCustomer(Long id, Pageable pageable){

        customerRepository.findById(id).orElseThrow(() -> new NotFoundIdException("No records found for this id"));

        var rentalsPage = rentalRepository.findByIdCustomer(id, pageable);

        return rentalsPage.map(r -> new RentalDTO(
                r.getId(),
                r.getCustomer(),
                r.getCar(),
                r.getRentalDate(),
                r.getReturnDate()
        ));
    }

}
