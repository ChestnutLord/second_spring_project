package com.example.springtodolist.repositiry;

import com.example.springtodolist.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepositoryDB extends JpaRepository<Contact, Long> {
    void deleteByNumber(String number);

    Contact findStudentByNumber(String email);
}