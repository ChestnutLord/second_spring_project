package com.example.springtodolist.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contact {
    @GeneratedValue
    @Id
    private Long id;

    private String name;

    @Column(unique = true)
    private String number;

    private String address;

}
