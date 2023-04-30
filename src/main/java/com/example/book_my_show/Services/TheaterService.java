package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.TheaterConvertor;
import com.example.book_my_show.EntryDtos.TheaterEntryDto;
import com.example.book_my_show.Enum.SeatType;
import com.example.book_my_show.Repository.TheaterRepository;
import com.example.book_my_show.Repository.TheaterSeatRepository;
import com.example.book_my_show.model.TheaterEntity;
import com.example.book_my_show.model.TheaterSeatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    @Autowired
    TheaterRepository theaterRepository;



    public String addTheater (TheaterEntryDto theaterEntryDto) throws Exception {

        if(theaterEntryDto.getName()==null || theaterEntryDto.getLocation()==null){

            throw new Exception ("Name or Location value is not valid.");
        }


        TheaterEntity theaterEntity = TheaterConvertor.convertTheaterDtoToEntity(theaterEntryDto);
        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats(theaterEntryDto,theaterEntity);

        theaterEntity.setTheaterSeatEntityList(theaterSeatEntityList);

        theaterRepository.save(theaterEntity);
        return "Theater added successfully !";
    }
    public List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDto theaterEntryDto,TheaterEntity theaterEntity){
        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();


        int noOfClassicSeats = theaterEntryDto.getClassicSeatCount();
        int noOfPremiumSeats = theaterEntryDto.getPremiumSeatCount();


        for(int count=1; count<=noOfClassicSeats;count++){
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder().seatType(SeatType.CLASSIC).
                    seatNumber(count+"C").theaterEntity(theaterEntity).build();
            theaterSeatEntityList.add(theaterSeatEntity);
        }
        for(int count=1;count<=noOfPremiumSeats;count++){
            TheaterSeatEntity theaterSeatEntity =TheaterSeatEntity.builder().seatType(SeatType.PREMIUM)
                    .seatNumber((count+"P")).theaterEntity(theaterEntity).build();

            theaterSeatEntityList.add(theaterSeatEntity);

        }

        return theaterSeatEntityList;
    }

}
