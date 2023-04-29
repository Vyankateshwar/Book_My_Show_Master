package com.example.book_my_show.Controller;


import com.example.book_my_show.EntryDtos.MovieEntryDto;
import com.example.book_my_show.Services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieController {

    @Autowired
    MovieService movieService;


    @PostMapping ("/add")
    public ResponseEntity addMovie(@RequestBody MovieEntryDto movieEntryDto){
       try{
          String response = movieService.addMovie(movieEntryDto); ;
          return new ResponseEntity<>(response,HttpStatus.CREATED);
       }
       catch (Exception e){
           String result = "Movie can not be added.";
           return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
       }

    }

}
