package com.StreamFlix.StreamFlix.controllers;

import com.StreamFlix.StreamFlix.models.Category;
import com.StreamFlix.StreamFlix.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category> createCategory (@RequestBody Category category){
        return new ResponseEntity<>(
                categoryService.createCategory(category),
                HttpStatus.CREATED
        );
    }

    @GetMapping("")
    public ResponseEntity<List<Category>>getAllCategories() {
        return new ResponseEntity<>(
                categoryService.getAllCategories(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById (@PathVariable Long id){
        Category category = categoryService.getCategoryById(id);
        if (category != null)
            return new ResponseEntity<>(
                    category,
                    HttpStatus.OK
            );
        else
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category category){
        Category result = categoryService.updateCategory(id, category);
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
    public ResponseEntity<?> deleteCategory (@PathVariable Long id){
        Category category = categoryService.getCategoryById(id);
        if (category!=null)
            return new ResponseEntity<>(
                    category,
                    HttpStatus.OK
            );
        else
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
    }

}
