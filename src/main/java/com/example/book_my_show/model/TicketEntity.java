package com.example.book_my_show.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name="tickets")
@Data
@NoArgsConstructor

public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String movieName;

    private LocalDate movieDate;

    private LocalTime movieTime;

    private int totalAmmount;

    private String ticketID = UUID.randomUUID().toString();

    private String theaterName;


    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;


}
