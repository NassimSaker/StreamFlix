package com.StreamFlix.StreamFlix.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "section_films",
            joinColumns = {
                    @JoinColumn(name = "section_id")
            },inverseJoinColumns = {
            @JoinColumn(name = "film_id")
    }
    )
    private List<Film> films;


}
