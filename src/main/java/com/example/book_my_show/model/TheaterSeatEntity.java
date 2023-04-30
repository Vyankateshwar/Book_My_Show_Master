package com.example.book_my_show.model;


import com.example.book_my_show.Enum.SeatType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor


@Table(name="theater_seats")
public class TheaterSeatEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;

    @Enumerated (value = EnumType.STRING )
    private SeatType seatType;
    private String seatNumber;

    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;

}
