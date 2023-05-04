package com.example.book_my_show.Services;


import com.example.book_my_show.Convertors.TicketConvertor;
import com.example.book_my_show.EntryDtos.TicketEntryDto;
import com.example.book_my_show.Repository.ShowRepository;
import com.example.book_my_show.Repository.TicketRepository;
import com.example.book_my_show.Repository.UserRepository;
import com.example.book_my_show.model.ShowEntity;
import com.example.book_my_show.model.ShowSeatEntity;
import com.example.book_my_show.model.TicketEntity;
import com.example.book_my_show.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;




    public String bookTicket(TicketEntryDto ticketEntryDto) throws Exception{
        TicketEntity ticketEntity= TicketConvertor.convertTicketDtoToEntity(ticketEntryDto);

        //Check requested seats are available ?
        int totalAmount=amountCal(ticketEntryDto);
        boolean isValid =true;
        if(totalAmount==0){
            isValid =false;
        }

        if(!isValid){
           throw new Exception("Seat no is already booked") ;
        }
        ticketEntity.setTotalAmmount(totalAmount);
        ticketEntity.setTicketID(UUID.randomUUID().toString());
        int showId = ticketEntryDto.getShowId();
        ShowEntity showEntity = showRepository.findById(showId).get();
        ticketEntity.setMovieDate(showEntity.getShowDate());
        ticketEntity.setTheaterName(showEntity.getTheaterEntity().getName());
        ticketEntity.setMovieName(showEntity.getMovieEntity().getMoviename());
        ticketEntity.setMovieTime(showEntity.getShowTime());
        String bookedSeats = "";
       for(String x : ticketEntryDto.getRequestedSeats()){
           bookedSeats=bookedSeats+x+",";
       }
       ticketEntity.setBookedSeats(bookedSeats);
       int userId = ticketEntryDto.getUserId();
       UserEntity userEntity =userRepository.findById(userId).get();
       ticketEntity.setUserEntity(userEntity);

       ticketEntity.setShowEntity(showEntity);

       //save the parent

        List<TicketEntity> ticketEntityList = showEntity.getTicketEntityList();
        ticketEntityList.add(ticketEntity);
        showEntity.setTicketEntityList(ticketEntityList);
        showRepository.save(showEntity);

        List<TicketEntity> ticketEntityList1 = userEntity.getBookedTicketEntityList();
        ticketEntityList1.add(ticketEntity);
        userEntity.setBookedTicketEntityList(ticketEntityList1);
        userRepository.save(userEntity);


       return "ticket is booked successfully";







    }

   public int amountCal(TicketEntryDto ticketEntryDto){
        int showId = ticketEntryDto.getShowId();
        ShowEntity showEntity = showRepository.findById(showId).get();
        List<ShowSeatEntity> showSeatEntityList=showEntity.setShowSeatEntityList();
        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();
        int totalAmount = 0;
        for(ShowSeatEntity x:showSeatEntityList){
            String seatNo= x.getSeatNo();
            if(requestedSeats.contains(seatNo)){
                if(x.isBooked()==true){
                    return 0;
                }
                totalAmount=totalAmount+x.getPrice();
                x.setBooked(true);
                x.setBookedAt(new Date());
            }
        }
        //all the seats requested was available;
        return totalAmount;





    }

}
