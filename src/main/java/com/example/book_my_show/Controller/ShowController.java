package com.example.book_my_show.Controller;


import com.example.book_my_show.EntryDtos.ShowEntryDto;
import com.example.book_my_show.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/show")

public class ShowController {
    @Autowired
    ShowService showService;

    public String addShow (@RequestBody ShowEntryDto showEntryDto){
        return showService.addShow(showEntryDto);

    }


}
