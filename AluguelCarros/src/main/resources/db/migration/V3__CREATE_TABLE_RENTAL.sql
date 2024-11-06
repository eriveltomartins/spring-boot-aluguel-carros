CREATE TABLE rentals (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    car_id BIGINT NOT NULL,
    rental_date DATETIME,
    return_date DATETIME,
    CONSTRAINT fk_customer
        FOREIGN KEY (customer_id) REFERENCES customers(id),
    CONSTRAINT fk_car
        FOREIGN KEY (car_id) REFERENCES car(id)
);
