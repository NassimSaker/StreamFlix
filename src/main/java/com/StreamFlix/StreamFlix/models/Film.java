package com.StreamFlix.StreamFlix.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

    private String title;
    private String synopsis;
    private String year;
    private String url_bda;
    private String url_film;
    private boolean isPublic;
    @ManyToMany(mappedBy = "films")
    private List<Category> categories= new ArrayList<>();






}
