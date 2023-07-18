package com.StreamFlix.StreamFlix.services;


import com.StreamFlix.StreamFlix.models.Film;
import com.StreamFlix.StreamFlix.models.Section;

import java.util.List;

public interface SectionService {

    Section createSection (Section section);
    List<Section> getAllSections();
    Section getSectionById(Long id);
    Section updateSection(Long id, Section section);
    Section deleteSection (Long id);



}
