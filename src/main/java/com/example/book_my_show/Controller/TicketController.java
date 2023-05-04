package com.example.book_my_show.Controller;


import com.example.book_my_show.EntryDtos.TicketEntryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")

public class TicketController {

    @PostMapping

    public ResponseEntity bookTicket(@RequestBody TicketEntryDto ticketEntryDto){


    }

}
