package erivelto.system.AluguelCarros.service;

import erivelto.system.AluguelCarros.dto.RentalDTO;
import erivelto.system.AluguelCarros.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public Page<RentalDTO> getRentalsByIdCustomer(Long id, Pageable pageable){
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
