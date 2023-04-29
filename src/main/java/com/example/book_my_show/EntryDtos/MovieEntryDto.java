package com.example.book_my_show.EntryDtos;


import com.example.book_my_show.Enum.Genre;
import com.example.book_my_show.Enum.Language;

import lombok.Data;

@Data
public class MovieEntryDto {



    private String moviename;
    private double ratings;
    private int duration;

    private Genre genre;

    private Language language;

}
