package com.sparta.engineering72.sakilaproject.respositories;

import com.sparta.engineering72.sakilaproject.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
