package erivelto.system.AluguelCarros.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rental")
public class RentalController {

    @GetMapping("/customer/{customerId}")
    public void catchRentals(){

    }
}
