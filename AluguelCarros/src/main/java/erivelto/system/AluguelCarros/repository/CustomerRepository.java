package erivelto.system.AluguelCarros.repository;

import erivelto.system.AluguelCarros.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
