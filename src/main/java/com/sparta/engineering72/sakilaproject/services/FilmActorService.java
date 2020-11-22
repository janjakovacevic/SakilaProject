package com.sparta.engineering72.sakilaproject.services;

import com.sparta.engineering72.sakilaproject.entities.FilmActor;
import com.sparta.engineering72.sakilaproject.respositories.FilmActorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmActorService {

    private final FilmActorRepository filmActorRepository;

    public FilmActorService(FilmActorRepository filmActorRepository){
        this.filmActorRepository = filmActorRepository;
    }

    public List<FilmActor> getAllFilmActors(){
        return filmActorRepository.findAll();
    }


}
