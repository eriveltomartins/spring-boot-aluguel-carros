package erivelto.system.AluguelCarros.model;

import jakarta.persistence.*;

@Entity(name = "Car")
@Table(name = "Car")
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

}
