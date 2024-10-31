package erivelto.system.AluguelCarros.service;

import erivelto.system.AluguelCarros.dto.CarDTO;
import erivelto.system.AluguelCarros.model.Car;
import erivelto.system.AluguelCarros.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public void saveVehicle(Car data){
        carRepository.save(data);

        System.out.println("Save vehicle!!");
    }

    public Car searchVehicleWithId(Long id){

        return carRepository.findById(id).orElse(null);
    }

    public Car updateVehicle(CarDTO data, Long id){
        var car = carRepository.findById(id).orElse(null);

        car.setModel(data.model());
        car.setBrand(data.brand());
        car.setLicensePlate(data.plate());

        carRepository.save(car);

        return car;
    }

    public void deleteVehicleById(Long id){
        carRepository.deleteById(id);
    }
}
