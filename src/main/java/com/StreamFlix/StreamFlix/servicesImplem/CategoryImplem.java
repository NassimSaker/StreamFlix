package com.StreamFlix.StreamFlix.servicesImplem;

import com.StreamFlix.StreamFlix.models.Category;
import com.StreamFlix.StreamFlix.repositories.CategoryRepository;
import com.StreamFlix.StreamFlix.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryImplem implements CategoryService {

    @Autowired
    public CategoryRepository categoryRepo;
    @Override
    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepo.findById(id);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public void deleteById(Long id){
        categoryRepo.deleteById(id);
    }
}
