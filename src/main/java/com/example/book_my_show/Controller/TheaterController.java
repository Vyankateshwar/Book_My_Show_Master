package com.example.book_my_show.Controller;


import com.example.book_my_show.EntryDtos.TheaterEntryDto;
import com.example.book_my_show.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/theater")

public class TheaterController {

    @Autowired
    TheaterService theaterService;

    public String addTheater(@RequestBody TheaterEntryDto theaterEntryDto){


    }
}
