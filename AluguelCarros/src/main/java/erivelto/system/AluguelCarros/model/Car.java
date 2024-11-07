package erivelto.system.AluguelCarros.model;

import erivelto.system.AluguelCarros.dto.CarDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Car")
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model", nullable = false, length = 255)
    private String model;

    @Column(name = "brand", nullable = false, length = 255)
    private String brand;

    @Column(name = "license_plate", nullable = false, length = 255)
    private String licensePlate;

    public Car() {
    }

    public Car(Long id, String model, String brand, String licensePlate) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.licensePlate = licensePlate;
    }

    public Car(CarDTO data){
        this.model = data.model();
        this.brand = data.brand();
        this.licensePlate = data.plate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(model, car.model) && Objects.equals(brand, car.brand) && Objects.equals(licensePlate, car.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand, licensePlate);
    }
}
