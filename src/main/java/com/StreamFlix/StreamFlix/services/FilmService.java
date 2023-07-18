package com.StreamFlix.StreamFlix.services;

import com.StreamFlix.StreamFlix.models.Film;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    Film createFilm (Film film);
    List<Film> getAllFilms();
    Optional<Film> getFilmById(Long id);
    Film updateFilm(Long id, Film film);
    void deleteById (Long id);
}
