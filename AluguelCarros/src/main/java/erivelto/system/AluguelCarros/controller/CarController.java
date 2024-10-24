package erivelto.system.AluguelCarros.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/car")
@RestController
public class CarController {

    @PostMapping
    public void createVehicle(){
        
    }

    @GetMapping("/{id}")
    public String catchCar(){
        return "Hello car";
    }

    @PutMapping("/{id}")
    public void updateCar(){

    }
}
