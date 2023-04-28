package com.example.book_my_show.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Entity
@Table(name="theaters")
@NoArgsConstructor
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;

    //this is a parent wrt theaterseats

    @OneToMany(mappedBy = "theaterEntity",cascade = CascadeType.ALL)
    private ArrayList<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<TheaterSeatEntity>();



}
