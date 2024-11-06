package erivelto.system.AluguelCarros.repository;

import erivelto.system.AluguelCarros.model.Rental;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    @Query("SELECT r FROM Rental r WHERE r.customer.id = :id")
    Page<Rental> findByIdCustomer(@Param("id") Long id, Pageable pageable);
}
