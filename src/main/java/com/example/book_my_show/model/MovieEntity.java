package com.example.book_my_show.model;


import com.example.book_my_show.Enum.Genre;
import com.example.book_my_show.Enum.Language;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="movies")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String moviename;
    private double ratings;
    private int duration;
    @Enumerated (value = EnumType.STRING)
    private Genre genre;
    @Enumerated (value = EnumType.STRING)
    private Language language;


    //this is parent wrt showEntity
    @OneToMany (mappedBy = "movieEntity",cascade = CascadeType.ALL)
    private List<ShowEntity> showEntityList = new ArrayList<>();
}
