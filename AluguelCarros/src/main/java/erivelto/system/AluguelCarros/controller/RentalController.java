package erivelto.system.AluguelCarros.controller;

import erivelto.system.AluguelCarros.dto.RentalDTO;
import erivelto.system.AluguelCarros.model.Rental;
import erivelto.system.AluguelCarros.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rental")
@RestController
public class RentalController {

    @Autowired
    private RentalService service;

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Page<RentalDTO>> getRentals(
            @PathVariable Long customerId,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "12") Integer size,
            @RequestParam(value = "direction", defaultValue = "asc") String direction
    ){
        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "id"));
        var rentals = service.getRentalsByIdCustomer(customerId, pageable);

        return ResponseEntity.ok(rentals);
    }
}
