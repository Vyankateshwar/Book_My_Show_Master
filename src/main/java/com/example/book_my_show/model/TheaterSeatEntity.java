package com.example.book_my_show.model;


import com.example.book_my_show.Genres.SeatType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="theater_seats")
public class TheaterSeatEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;
    private SeatType seatType;
    private int seatNumber;

    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;

}
