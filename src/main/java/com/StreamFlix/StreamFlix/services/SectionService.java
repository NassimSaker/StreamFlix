package com.StreamFlix.StreamFlix.services;


import com.StreamFlix.StreamFlix.models.Section;

import java.util.List;
import java.util.Optional;

public interface SectionService {

    Section createSection (Section section);
    List<Section> getAllSections();
    Optional<Section> getSectionById(Long id);
    Section updateSection(Long id, Section section);
    void deleteById (Long id);



}
