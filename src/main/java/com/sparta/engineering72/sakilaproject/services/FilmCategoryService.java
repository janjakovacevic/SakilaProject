package com.sparta.engineering72.sakilaproject.services;

import com.sparta.engineering72.sakilaproject.entities.Film;
import com.sparta.engineering72.sakilaproject.entities.FilmActor;
import com.sparta.engineering72.sakilaproject.entities.FilmCategory;
import com.sparta.engineering72.sakilaproject.respositories.FilmActorRepository;
import com.sparta.engineering72.sakilaproject.respositories.FilmCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmCategoryService {
    private final FilmCategoryRepository filmCategoryRepository;

    public FilmCategoryService(FilmCategoryRepository filmCategoryRepository){
        this.filmCategoryRepository = filmCategoryRepository;
    }

    public List<FilmCategory> getAllFilmCategories(){
        return filmCategoryRepository.findAll();
    }

    public List<Film> getFilmsByCategory(Integer categoryId){
        List<FilmCategory> filmCategoryList = getAllFilmCategories();
        List<Film> filmsByActor = new ArrayList<>();
        for(FilmCategory filmCategory : filmCategoryList){
            if(filmCategory.getCategory().getCategoryId() == categoryId)
                filmsByActor.add(filmCategory.getFilm());
        }
        return filmsByActor;
    }
}
