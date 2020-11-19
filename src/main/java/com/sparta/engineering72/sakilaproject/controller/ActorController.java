package com.sparta.engineering72.sakilaproject.controller;

import com.sparta.engineering72.sakilaproject.entities.Actor;
import com.sparta.engineering72.sakilaproject.services.ActorService;
import com.sparta.engineering72.sakilaproject.services.FilmActorService;
import com.sparta.engineering72.sakilaproject.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ActorController {

    private FilmService filmService;
    private ActorService actorService;
    private FilmActorService filmActorService;

    @Autowired
    public ActorController(FilmService filmService, ActorService actorService, FilmActorService filmActorService) {
        this.filmService = filmService;
        this.actorService = actorService;
        this.filmActorService = filmActorService;
    }

    @GetMapping("/actors")
    public String getActors(ModelMap modelMap,
                            @RequestParam(value = "firstName", defaultValue = "ALL ACTORS") String firstNameFilter,
                            @RequestParam(value = "lastName", defaultValue = "ALL ACTORS") String lastNameFilter) {
        List<Actor> actors;
        if (firstNameFilter.equals("ALL ACTORS") && lastNameFilter.equals("ALL ACTORS")) {
            actors = actorService.getAllActors();
        } else if (lastNameFilter.equals("ALL ACTORS")){
            actors = actorService.getActorsByFirstName(firstNameFilter);
        } else if (firstNameFilter.equals("ALL ACTORS")) {
            actors = actorService.getActorsByLastName(lastNameFilter);
        } else {
            actors = actorService.getActorsByFullName(firstNameFilter, lastNameFilter);
        }
        modelMap.addAttribute("actors", actors);
        modelMap.addAttribute("allActors", actorService.getAllActors());
        return "actors/actors";
    }

    @GetMapping("/actors/details")
    public String getActorFilmDetails(ModelMap modelMap,
                                      @RequestParam(value = "id") Integer id) {
        modelMap.addAttribute("name", actorService.getActorFullNameFromID(id));
        modelMap.addAttribute("actor", actorService.getActorByID(id));
        modelMap.addAttribute("films", filmActorService.getFilmsByActor(id));
        return "actors/actorDetails";
    }
}
