package erivelto.system.AluguelCarros.service;

import erivelto.system.AluguelCarros.dto.CarDTO;
import erivelto.system.AluguelCarros.exceptions.NotFoundIdException;
import erivelto.system.AluguelCarros.model.Car;
import erivelto.system.AluguelCarros.repository.CarRepository;
import erivelto.system.AluguelCarros.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RentalRepository rentalRepository;

    public void saveVehicle(Car data){
        carRepository.save(data);
    }

    public Car searchVehicleWithId(Long id){

        return carRepository.findById(id).orElseThrow(() -> new NotFoundIdException("No records found for this id"));
    }

    public Car updateVehicle(CarDTO data, Long id){
        var car = carRepository.findById(id).orElseThrow(() -> new NotFoundIdException("No records found for this id"));

        car.setModel(data.model());
        car.setBrand(data.brand());
        car.setLicensePlate(data.plate());

        carRepository.save(car);

        return car;
    }

    public void deleteVehicleById(Long id){
        carRepository.findById(id).orElseThrow(() -> new NotFoundIdException("No records found for this id"));

        rentalRepository.deleteByCarId(id);

        carRepository.deleteById(id);
    }
}
