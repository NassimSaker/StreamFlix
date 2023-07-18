package com.StreamFlix.StreamFlix.repositories;

import com.StreamFlix.StreamFlix.models.Film;
import com.StreamFlix.StreamFlix.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    Film save (Film film);
    Optional<Film> findById(Long id);
    List<Film> findAll();
}
