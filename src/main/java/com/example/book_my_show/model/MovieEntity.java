package com.example.book_my_show.model;


import com.example.book_my_show.Genres.Genre;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="movies")
@Data
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true,nullable = false)
    private String moviename;
    private double ratings;
    private int duration;
    @Enumerated (value = EnumType.STRING)
    private Genre genre;
    @Enumerated (value = EnumType.STRING)
    private Language language;

}
