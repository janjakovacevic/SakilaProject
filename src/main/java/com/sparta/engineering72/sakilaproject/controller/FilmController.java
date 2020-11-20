package com.sparta.engineering72.sakilaproject.controller;

import com.sparta.engineering72.sakilaproject.entities.Film;
import com.sparta.engineering72.sakilaproject.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
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
        modelMap.addAttribute("availableFilms", filmService.getAvailableFilms());
        modelMap.addAttribute("allFilms", filmService.getAllFilms());
        return "/films/films";
    }

    @GetMapping("/films/details")
    public String getFilmDetails(ModelMap modelMap,
                                 @RequestParam(value = "id") Integer id) {
        Film film = filmService.getFilmByID(id);
        boolean available = filmService.getAvailableFilms().contains(film);
        modelMap.addAttribute("available", available);
        modelMap.addAttribute("details", film);
        return "films/filmDetails";
    }

    @GetMapping("/owner/manage-films")
    public String getFilmDetails(ModelMap modelMap) {
        List<Film> films = filmService.getAllFilms();
        modelMap.addAttribute("films", films);
        return "/owner/manage-films";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Film film = new Film();

        model.addAttribute("film", film);

//        filmService.getAllSpecialFeatures

//        String releaseYear = "";
//        model.addAttribute("releaseYear", releaseYear);
//        LocalDate localDate = LocalDate.parse(releaseYear);
//        film.setReleaseYear(localDate);

        return "/owner/create-new-film";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("film") Film film, Model model) {
        film.setLastUpdate(Timestamp.from(Instant.now()));
        film.setReleaseYear(LocalDate.now().getYear()); //Fixme make it a choice
        //Fixme set language_id manually

        filmService.save(film);

        return "redirect:/films";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("/owner/edit-film");
        Film film = filmService.getFilmByID(id);
        mav.addObject("film", film);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        filmService.deleteFilmById(id);
        return "redirect:/owner/manage-films";
    }

}
