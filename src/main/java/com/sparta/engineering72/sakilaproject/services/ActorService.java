package com.sparta.engineering72.sakilaproject.services;

import com.sparta.engineering72.sakilaproject.entities.Actor;
import com.sparta.engineering72.sakilaproject.respositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    ActorRepository actorRepository;

    public List<Actor> getAllActors(){
        return (List<Actor>)actorRepository.findAll();
    }

    public Optional<Actor> getActorByID(int id){
        return actorRepository.findById(id);
    }

    public List<Actor> getActorsByFullName(String firstName, String lastName){
        return actorRepository.findActorsByFirstNameAndLastName(firstName, lastName);
    }

}
