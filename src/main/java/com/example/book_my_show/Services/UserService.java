package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.UserConvertor;
import com.example.book_my_show.EntryDtos.UserEntryDto;
import com.example.book_my_show.Repository.UserRepository;
import com.example.book_my_show.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
        @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto) throws Exception,NullPointerException{
        UserEntity userEntity= UserConvertor.convertUserDtoToEntity(userEntryDto);

        userRepository.save(userEntity);
        return "User Added Successfully !";

    }
}
