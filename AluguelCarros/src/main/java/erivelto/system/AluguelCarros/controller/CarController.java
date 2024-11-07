package erivelto.system.AluguelCarros.controller;

import erivelto.system.AluguelCarros.dto.CarDTO;
import erivelto.system.AluguelCarros.model.Car;
import erivelto.system.AluguelCarros.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("/car")
@RestController
public class CarController {

    @Autowired
    private CarService service;

    @PostMapping
    public ResponseEntity<?> createVehicle(@Validated @RequestBody CarDTO car, UriComponentsBuilder uriBuilder){
        var currentCar = new Car(car);
        service.saveVehicle(currentCar);

        var uri = uriBuilder.path("/car/{id}").buildAndExpand(currentCar.getId()).toUri();

        return ResponseEntity.created(uri).body(currentCar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        var currentCar = service.searchVehicleWithId(id);

        return ResponseEntity.ok(currentCar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CarDTO car, @PathVariable Long id){
        var currentCar = service.updateVehicle(car, id);

        return ResponseEntity.ok(currentCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteVehicleById(id);
        return ResponseEntity.noContent().build();
    }
}
