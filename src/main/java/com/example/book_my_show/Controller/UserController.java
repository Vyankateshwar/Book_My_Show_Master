package com.example.book_my_show.Controller;


import com.example.book_my_show.EntryDtos.UserEntryDto;
import com.example.book_my_show.Services.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser (@RequestBody UserEntryDto userEntryDto){
        try{
             String response = userService.addUser(userEntryDto);
             return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception e){

            String result = "User could not be added.";
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }


    }
}
