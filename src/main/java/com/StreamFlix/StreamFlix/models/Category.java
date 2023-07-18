package com.StreamFlix.StreamFlix.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "categories_films",
            joinColumns = {
                    @JoinColumn(name = "category_id")
            },inverseJoinColumns = {
            @JoinColumn(name = "film_id")
    }
    )
            private List<Film> films= new ArrayList<>();


}
