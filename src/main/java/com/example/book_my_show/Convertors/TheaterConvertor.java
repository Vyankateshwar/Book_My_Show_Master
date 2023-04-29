package com.example.book_my_show.Convertors;


import com.example.book_my_show.EntryDtos.TheaterEntryDto;
import com.example.book_my_show.model.TheaterEntity;

public class TheaterConvertor {

    public static TheaterEntity convertTheaterDtoToEntity (TheaterEntryDto theaterEntryDto){
       TheaterEntity theaterEntity= TheaterEntity.builder().name(theaterEntryDto.getName()).
               location(theaterEntryDto.getLocation()).build();

       return theaterEntity;
    }

}
