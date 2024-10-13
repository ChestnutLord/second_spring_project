package com.example.springtodolist.repositiry;

import com.example.springtodolist.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepositoryDB extends JpaRepository<Contact, Long>, ContactRepository {
    void deleteByNumber(String number);

    Optional<Contact> findContactByNumber(String email);
}