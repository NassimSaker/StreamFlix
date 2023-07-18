package com.StreamFlix.StreamFlix.controllers;

import com.StreamFlix.StreamFlix.models.Film;
import com.StreamFlix.StreamFlix.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("films")
public class FilmController {

    @Autowired
    FilmService filmService;

    @PostMapping("/add")
    public ResponseEntity<Film> createFilm (@RequestBody Film film){
        return new ResponseEntity<>(
                filmService.createFilm(film),
                HttpStatus.CREATED
        );
    }

    @GetMapping("")
    public ResponseEntity<List<Film>> getAllFilms() {
       return new ResponseEntity<>(
               filmService.getAllFilms(),
               HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFilmById (@PathVariable Long id){
        Film film = filmService.getFilmById(id);
        if (film != null)
            return new ResponseEntity<>(
                    film,
                    HttpStatus.OK
            );
        else
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFilm(@PathVariable Long id, @RequestBody Film film){
        Film result = filmService.updateFilm(id, film);
        if (result != null)
            return new ResponseEntity<>(
                    result,
                    HttpStatus.OK
            );
        else {
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFilm (@PathVariable Long id){
        Film film = filmService.getFilmById(id);
        if (film!=null)
            return new ResponseEntity<>(
                    film,
                    HttpStatus.OK
            );
        else
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
    }


}
