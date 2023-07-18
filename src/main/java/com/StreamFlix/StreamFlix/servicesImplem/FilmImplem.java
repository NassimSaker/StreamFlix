package com.StreamFlix.StreamFlix.servicesImplem;


import com.StreamFlix.StreamFlix.models.Film;
import com.StreamFlix.StreamFlix.repositories.FilmRepository;
import com.StreamFlix.StreamFlix.services.FilmService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FilmImplem implements FilmService {

    @Autowired
    FilmRepository filmRepo;
    @Override
    public Film createFilm(Film film) {
        return filmRepo.save(film);
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepo.findAll();
    }

    @Override
    public Optional<Film> getFilmById(Long id) {
        return filmRepo.findById(id);
    }

    @Override
    public Film updateFilm(Long id, Film film) {
        return filmRepo.save(film);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id);
    }
}
