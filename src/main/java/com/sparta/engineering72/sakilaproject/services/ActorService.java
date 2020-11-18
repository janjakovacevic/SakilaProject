package com.sparta.engineering72.sakilaproject.services;

import com.sparta.engineering72.sakilaproject.entities.Actor;
import com.sparta.engineering72.sakilaproject.respositories.ActorRepository;
import com.sparta.engineering72.sakilaproject.respositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }

    public List<Actor> getAllActors(){
        return (List<Actor>)actorRepository.findAll();
    }

    public Actor getActorByID(int id){
        return actorRepository.getActorsByActorId(id);
    }

    public List<Actor> getActorsByFullName(String firstName, String lastName){
        return actorRepository.findActorsByFirstNameAndLastName(firstName, lastName);
    }

}
