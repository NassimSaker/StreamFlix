package com.StreamFlix.StreamFlix.services;

import com.StreamFlix.StreamFlix.models.Category;

import java.util.List;
import java.util.Optional;


public interface CategoryService {

    Category createCategory (Category category);
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long id);
    Category updateCategory(Long id, Category category);
    void deleteById (Long id);
}
