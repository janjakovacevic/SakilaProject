package com.sparta.engineering72.sakilaproject.respositories;

import com.sparta.engineering72.sakilaproject.entities.FilmText;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmTextRepository extends JpaRepository<FilmText, Integer> {
    FilmText getFilmTextById(Integer id);
}
