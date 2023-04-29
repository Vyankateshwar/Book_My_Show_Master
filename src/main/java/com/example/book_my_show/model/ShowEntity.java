package com.example.book_my_show.model;


import com.example.book_my_show.Enum.ShowType;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = " shows")
public class ShowEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;


    private LocalDate showDate;

    private LocalTime showTime;


    private ShowType showType;

    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;


    //this is child wrt MovieEntity

    @ManyToOne
    @JoinColumn
    private  MovieEntity movieEntity;


    //this is child wrt theaterEntity

    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;

    @OneToMany(mappedBy = "showEntity", cascade = CascadeType.ALL)
    List<TicketEntity> ticketEntityList =new ArrayList<>();

    @OneToMany (mappedBy = "showEntity",cascade = CascadeType.ALL)
    List<ShowSeatEntity> showSeatEntityList= new ArrayList<>();


}
