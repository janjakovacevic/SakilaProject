package com.sparta.engineering72.sakilaproject.controller;

import com.sparta.engineering72.sakilaproject.entities.Actor;
import com.sparta.engineering72.sakilaproject.entities.Film;
import com.sparta.engineering72.sakilaproject.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ActorController {

    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actors")
    public String getActors(ModelMap modelMap,
                            @RequestParam(value = "firstName", defaultValue = "ALL ACTORS") String firstNameFilter,
                            @RequestParam(value = "lastName", defaultValue = "ALL ACTORS") String lastNameFilter) {
        List<Actor> actors, allActors;
        if (firstNameFilter.equals("ALL ACTORS") && lastNameFilter.equals("ALL ACTORS")) {
            actors = actorService.getAllActors();
        } else if (lastNameFilter.equals("ALL ACTORS")){
            actors = actorService.getActorsByFirstName(firstNameFilter);
        } else if (firstNameFilter.equals("ALL ACTORS")) {
            actors = actorService.getActorsByLastName(lastNameFilter);
        } else {
            actors = actorService.getActorsByFullName(firstNameFilter, lastNameFilter);
        }
        allActors = actorService.getAllActors();
        modelMap.addAttribute("actors", actors);
        modelMap.addAttribute("allActors", allActors);
        return "actors/actors";
    }

    @GetMapping("/actors/{id}")
    public String getFilmDetails(@PathVariable int id, ModelMap modelMap) {
        Actor actor = actorService.getActorByID(id);
        modelMap.addAttribute("details", actor);
        return "actors/actorDetails";
    }
}
