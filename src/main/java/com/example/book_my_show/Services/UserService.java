package com.example.book_my_show.Services;

import com.example.book_my_show.EntryDtos.UserEntryDto;
import com.example.book_my_show.Repository.UserRepository;
import com.example.book_my_show.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
        @Autowired
    UserRepository userRepository;

    public void addUser(UserEntryDto userEntryDto){

        UserEntity userEntity= UserEntity.builder().name(userEntryDto.getName()).
                age(userEntryDto.getAge()).
                email(userEntryDto.getEmail()).
                address(userEntryDto.getAddress()).
                mobile(userEntryDto.getMobile()).build();

        userRepository.save(userEntity);

    }
}
