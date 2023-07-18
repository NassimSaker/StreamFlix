package com.StreamFlix.StreamFlix.services;

import com.StreamFlix.StreamFlix.models.Film;

import java.util.List;

public interface FilmService {
    Film createFilm (Film film);
    List<Film> getAllFilms();
    Film getFilmById(Long id);
    Film updateFilm(Long id, Film film);
    Film deleteFilm (Long id);
}
