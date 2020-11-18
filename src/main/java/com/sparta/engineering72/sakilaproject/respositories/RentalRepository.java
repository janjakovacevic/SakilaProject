package com.sparta.engineering72.sakilaproject.respositories;

import com.sparta.engineering72.sakilaproject.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
