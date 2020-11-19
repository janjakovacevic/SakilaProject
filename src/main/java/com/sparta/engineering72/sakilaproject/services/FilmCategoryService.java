package com.sparta.engineering72.sakilaproject.services;

import com.sparta.engineering72.sakilaproject.entities.Film;
import com.sparta.engineering72.sakilaproject.entities.FilmCategory;
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


//            List<FilmCategory> filmCategoryList = getAllFilmCategories();
//        List<FilmCategory> filmsByCategory = new ArrayList<>();
//        for(FilmCategory filmCategory : filmCategoryList){
//            if(filmCategory.getCategoryId() == categoryId)
//                filmsByCategory.add(filmCategory);
//        }
//        return filmsByCategory;
}
