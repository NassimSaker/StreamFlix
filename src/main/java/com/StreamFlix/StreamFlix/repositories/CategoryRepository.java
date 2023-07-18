package com.StreamFlix.StreamFlix.repositories;

import com.StreamFlix.StreamFlix.models.Category;
import com.StreamFlix.StreamFlix.models.Section;
import com.StreamFlix.StreamFlix.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category save (Category category);
    Optional<Category> findById (Long id);
    List<Category> findAll();
}
