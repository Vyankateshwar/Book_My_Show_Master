package com.example.book_my_show.Convertors;

import com.example.book_my_show.EntryDtos.UserEntryDto;
import com.example.book_my_show.model.UserEntity;

public class UserConvertor {
    public static UserEntity convertUserDtoToEntity(UserEntryDto userEntryDto){

        UserEntity userEntity = UserEntity.builder().name(userEntryDto.getName()).
                age(userEntryDto.getAge()).email(userEntryDto.getEmail()).mobile(userEntryDto.getMobile()).
                address(userEntryDto.getAddress()).build();

        return userEntity;
    }
}
