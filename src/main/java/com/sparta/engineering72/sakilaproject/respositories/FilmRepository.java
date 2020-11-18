package com.sparta.engineering72.sakilaproject.respositories;

import com.sparta.engineering72.sakilaproject.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    List<Film> findByTitle(String title);
}
