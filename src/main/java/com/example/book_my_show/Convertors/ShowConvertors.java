package com.example.book_my_show.Convertors;

import com.example.book_my_show.EntryDtos.ShowEntryDto;
import com.example.book_my_show.model.ShowEntity;

public class ShowConvertors {

    public static ShowEntity createShowDtoToEntity (ShowEntryDto showEntryDto){
        ShowEntity showEntity = ShowEntity.builder().
                showTime(showEntryDto.getShowTime())
                .showDate(showEntryDto.getShowDate())
                .showType(showEntryDto.getShowType())
                .build();

        return showEntity;
    }

}
