package com.sparta.engineering72.sakilaproject.services;

import com.sparta.engineering72.sakilaproject.entities.Actor;
import com.sparta.engineering72.sakilaproject.entities.Film;
import com.sparta.engineering72.sakilaproject.respositories.CustomerRepository;
import com.sparta.engineering72.sakilaproject.respositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
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
}
