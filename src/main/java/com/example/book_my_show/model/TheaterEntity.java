package com.example.book_my_show.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="theaters")
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;

    //this is a parent wrt theaterseats

    @OneToMany(mappedBy = "theaterEntity",cascade = CascadeType.ALL)
    private List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<TheaterSeatEntity>();

    //this is parent wrt showEntity

    @OneToMany(mappedBy = "theaterEntity",cascade = CascadeType.ALL)
    private List<ShowEntity> showEntityList =new ArrayList<>();




}
