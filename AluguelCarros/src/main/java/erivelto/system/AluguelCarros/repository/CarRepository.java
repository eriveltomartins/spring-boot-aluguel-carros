package erivelto.system.AluguelCarros.repository;

import erivelto.system.AluguelCarros.model.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository {

    List<Car> findByModel(String model);

}
