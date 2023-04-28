package com.example.book_my_show.EntryDtos;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserEntryDto {



    private String name;
    private int age;

    private String email;

    private String mobile;
    private String address;

}
