package com.StreamFlix.StreamFlix.servicesImplem;

import com.StreamFlix.StreamFlix.models.Section;
import com.StreamFlix.StreamFlix.repositories.SectionRepository;
import com.StreamFlix.StreamFlix.services.SectionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SectionImplem implements SectionService {

    @Autowired
    SectionRepository sectionRepo;
    @Override
    public Section createSection(Section section) {
        return sectionRepo.save(section);
    }

    @Override
    public List<Section> getAllSections() {
        return sectionRepo.findAll();
    }

    @Override
    public Optional<Section> getSectionById(Long id) {
        return sectionRepo.findById(id);
    }

    @Override
    public Section updateSection(Long id, Section section) {
        return sectionRepo.save(section);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id);
    }
}
