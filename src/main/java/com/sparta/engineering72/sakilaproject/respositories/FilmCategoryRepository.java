package com.sparta.engineering72.sakilaproject.respositories;

import com.sparta.engineering72.sakilaproject.entities.FilmCategory;
import com.sparta.engineering72.sakilaproject.entities.FilmCategoryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmCategoryRepository extends JpaRepository<FilmCategory, FilmCategoryPK>
{
    FilmCategory getFilmCategoryById(Integer id);
}
