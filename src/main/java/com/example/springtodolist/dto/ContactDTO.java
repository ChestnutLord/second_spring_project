package com.example.springtodolist.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // нужен ли если есть @Data? TODO
public class ContactDTO {

    private Long id;

    private String name;

    @Column(unique = true)
    private String number;

    private String address;
}
