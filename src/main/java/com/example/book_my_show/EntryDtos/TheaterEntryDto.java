package com.example.book_my_show.EntryDtos;


import lombok.Data;

@Data
public class TheaterEntryDto {

    private String name;

    private String location;

    private int classicSeatCount;

    private  int premiumSeatCount;
}
