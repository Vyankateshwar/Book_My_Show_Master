package com.example.book_my_show.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users")
@Getter
@Setter
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor


public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Column(unique = true,nullable = false)
    private String email;
    @Nonnull
    @Column (unique = true,nullable = false)
    private String mobile;
    private String address;

}
