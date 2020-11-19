package com.sparta.engineering72.sakilaproject.services;

import com.sparta.engineering72.sakilaproject.entities.Film;
import com.sparta.engineering72.sakilaproject.respositories.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {

    private final FilmRepository filmRepository;
    private final InventoryService inventoryService;
    private final FilmCategoryService filmCategoryService;

    public FilmService(FilmRepository filmRepository, InventoryService inventoryService, FilmCategoryService filmCategoryService){
        this.filmRepository = filmRepository;
        this.inventoryService = inventoryService;
        this.filmCategoryService = filmCategoryService;
    }

    public List<Film> getAllFilms(){
        return (List<Film>)filmRepository.findAll();
    }

    public Film getFilmByID(int id){
        return filmRepository.getFilmByFilmId(id);
    }

    public List<Film> getFilmsByTitle(String title){
        return filmRepository.findByTitle(title);
    }


//    public List<Film> getFilmsByCategory(Integer id){
//        List<Film> films = getAllFilms();
//        List<Film> filmByCategory = new ArrayList<>();
//        for(Film film : films){
//            if(filmCategoryService.)
//        }
//
//        return null;
//    }

    public List<Film> getAvailableFilms(){
//        List<Film> films = getAllFilms();
//        List<Film> availableFilms = new ArrayList<>();
//        for(Film film : films){
//            if(inventoryService.isAvailable(film.getFilmId())) availableFilms.add(film);
//        }

        return filmRepository.getAvailableFilms();
    }


    public List<Film> getFilmsByCategory(Integer id){
        return filmRepository.getAllFilmsByCategory(id);
    }

    public List<Film> getFilmsByActor(Integer id){
        return filmRepository.getAllFilmsByActor(id);
    }

}
