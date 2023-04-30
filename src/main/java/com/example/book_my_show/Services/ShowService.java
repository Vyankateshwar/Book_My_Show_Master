package com.example.book_my_show.Services;


import com.example.book_my_show.Convertors.ShowConvertors;
import com.example.book_my_show.EntryDtos.ShowEntryDto;
import com.example.book_my_show.Enum.SeatType;
import com.example.book_my_show.Repository.MovieRepository;
import com.example.book_my_show.Repository.ShowRepository;
import com.example.book_my_show.Repository.TheaterRepository;
import com.example.book_my_show.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;


    public String addShow (ShowEntryDto showEntryDto){
        ShowEntity showEntity = ShowConvertors.createShowDtoToEntity(showEntryDto);
        int movieId = showEntryDto.getMovieId();
        int theaterId = showEntryDto.getTheaterId();

        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        TheaterEntity theaterEntity= theaterRepository.findById(theaterId).get();

        showEntity.setTheaterEntity(theaterEntity);
        showEntity.setMovieEntity(movieEntity);

        List<ShowSeatEntity> showSeatEntityList =  createShowSeatEntity(showEntryDto,showEntity);
        showEntity.setShowSeatEntityList(showSeatEntityList);


        List<ShowEntity> existingMovioeShowEntityList = movieEntity.getShowEntityList(); //check existing ShowEntityList & Add our new Show Entity into it
        existingMovioeShowEntityList.add(showEntity);
        movieEntity.setShowEntityList(existingMovioeShowEntityList); //setting showEntityList our new showEntityList after adding showentity
        movieRepository.save(movieEntity);

        List<ShowEntity> existingTheaterShowEntityList = theaterEntity.getShowEntityList();
        existingTheaterShowEntityList.add(showEntity);
        theaterEntity.setShowEntityList(existingTheaterShowEntityList);
        theaterRepository.save(theaterEntity);

        return "Show Added Sucessfully.";



    }

    public List<ShowSeatEntity> createShowSeatEntity(ShowEntryDto showEntryDto,ShowEntity showEntity){
        TheaterEntity theaterEntity = showEntity.getTheaterEntity();
        List<TheaterSeatEntity> theaterSeatEntityList = theaterEntity.getTheaterSeatEntityList();
        List<ShowSeatEntity> showSeatEntityList =new ArrayList<>();
        for(TheaterSeatEntity theaterSeatEntity : theaterSeatEntityList){
            ShowSeatEntity showSeatEntity = new ShowSeatEntity();
            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNumber());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());


            if(theaterSeatEntity.getSeatType().equals(SeatType.CLASSIC)) {
                showSeatEntity.setPrice(showEntryDto.getShowClassicSeatPrice());
            }
            else {
                showSeatEntity.setPrice(showEntryDto.getShowPremiumSeatPrice());
            }
            showSeatEntity.setBooked(false);
            showSeatEntityList.add(showSeatEntity);

        }
            return showSeatEntityList;

    }
}
