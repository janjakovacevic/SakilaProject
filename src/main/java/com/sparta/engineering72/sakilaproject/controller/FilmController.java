package com.sparta.engineering72.sakilaproject.controller;

import com.sparta.engineering72.sakilaproject.entities.Actor;
import com.sparta.engineering72.sakilaproject.entities.Film;
import com.sparta.engineering72.sakilaproject.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FilmController {

    private FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public String getFilms(ModelMap modelMap, @RequestParam(value = "title", defaultValue = "ALL FILMS") String filter) {
        List<Film> films;
        if (filter.equals("ALL FILMS")){
            films = filmService.getAllFilms();
        }
        else {
            films = filmService.getFilmsByTitle(filter);
        }
        modelMap.addAttribute("films", films);
        modelMap.addAttribute("allFilms", filmService.getAllFilms());
        return "/films/films";
    }

    @GetMapping("/films/details")
    public String getFilmDetails(ModelMap modelMap,
                                 @RequestParam(value = "id") Integer id) {
        modelMap.addAttribute("details", filmService.getFilmByID(id));
        return "films/filmDetails";
    }

    public Film findFilmByID(Integer id) {
        return filmService.getFilmByID(id);
    }



}
