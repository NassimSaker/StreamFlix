package com.StreamFlix.StreamFlix.controllers;

import com.StreamFlix.StreamFlix.models.Section;
import com.StreamFlix.StreamFlix.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sections")
public class SectionController {

    @Autowired
    SectionService sectionService;

    @PostMapping("/add")
    public ResponseEntity<Section> createFilm (@RequestBody Section section){
        return new ResponseEntity<>(
                sectionService.createSection(section),
                HttpStatus.CREATED
        );
    }

    @GetMapping("")
    public ResponseEntity<List<Section>> getAllSection() {
        return new ResponseEntity<>(
                sectionService.getAllSections(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSectionById (@PathVariable Long id){
        Section section = sectionService.getSectionById(id);
        if (section != null)
            return new ResponseEntity<>(
                    section,
                    HttpStatus.OK
            );
        else
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSection(@PathVariable Long id, @RequestBody Section section) {
        Section result = sectionService.updateSection(id, section);
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
    public ResponseEntity<?> deleteSection (@PathVariable Long id){
        Section section = sectionService.getSectionById(id);
        if (section!=null)
            return new ResponseEntity<>(
                    HttpStatus.OK
            );
        else
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
    }


}
