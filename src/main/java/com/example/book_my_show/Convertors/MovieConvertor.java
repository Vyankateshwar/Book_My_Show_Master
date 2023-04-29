package com.example.book_my_show.Convertors;


import com.example.book_my_show.EntryDtos.MovieEntryDto;
import com.example.book_my_show.model.MovieEntity;

public class MovieConvertor {

    public static MovieEntity convertMovieDtoToEntity(MovieEntryDto movieEntryDto){

        MovieEntity movieEntity = MovieEntity.builder().genre(movieEntryDto.getGenre()).
                duration(movieEntryDto.getDuration()).ratings(movieEntryDto.getRatings()).
                language(movieEntryDto.getLanguage()).moviename(movieEntryDto.getMoviename()).build();

        return movieEntity;

    }
}
