package erivelto.system.AluguelCarros.dto;

import erivelto.system.AluguelCarros.model.Car;
import erivelto.system.AluguelCarros.model.Customer;

import java.time.LocalDateTime;

public record RentalDTO(
        Long id,
        Customer customer,
        Car car,
        LocalDateTime rentalDate,
        LocalDateTime returnDate
) {
}
