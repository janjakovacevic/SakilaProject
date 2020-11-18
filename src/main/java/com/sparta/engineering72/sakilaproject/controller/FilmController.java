package com.sparta.engineering72.sakilaproject.controller;

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
        List<Film> allFilms;
        if (filter.equals("ALL FILMS")){
            films = filmService.getAllFilms();
        }
        else {
            films = filmService.getFilmsByTitle(filter);
        }
        allFilms = filmService.getAllFilms();
        modelMap.addAttribute("allFilms", allFilms);
        modelMap.addAttribute("films",films);
        return "/films/films";
    }

    @GetMapping("/films/{id}")
    public String getFilmDetails(@PathVariable int id, ModelMap modelMap) {
        Film film = filmService.getFilmByID(id);
        modelMap.addAttribute("details", film);
        return "films/filmDetails";
    }

}
