package com.example.book_my_show.EntryDtos;


import com.example.book_my_show.Enum.ShowType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDto {


    private LocalDate showDate;

    private LocalTime showTime;

    private ShowType showType;

    private int movieId;

    private int theaterId;

    private int ShowClassicSeatPrice;

    private int ShowPremiumSeatPrice;






}
