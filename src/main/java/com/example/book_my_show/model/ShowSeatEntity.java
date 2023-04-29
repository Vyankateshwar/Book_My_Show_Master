package com.example.book_my_show.model;


import com.example.book_my_show.Enum.SeatType;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table (name = "show_seat")
@Data
@NoArgsConstructor
public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private boolean isBooked;
    private int price; //price for that time of that show

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private String seatNo;

    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;

}
