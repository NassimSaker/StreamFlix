package com.StreamFlix.StreamFlix.services;

import com.StreamFlix.StreamFlix.models.Category;
import com.StreamFlix.StreamFlix.models.Film;
import com.StreamFlix.StreamFlix.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    Category createCategory (Category category);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category updateCategory(Long id, Category category);
    Category deleteCategory (Long id);

}
