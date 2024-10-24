package erivelto.system.AluguelCarros.service;

import erivelto.system.AluguelCarros.repository.CarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CarService {

    @Autowired

    private CarRepository carRepository;

}
