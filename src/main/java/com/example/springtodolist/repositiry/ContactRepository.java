package com.example.springtodolist.repositiry;

import com.example.springtodolist.model.Contact;

import java.util.Optional;

public interface ContactRepository {
    void deleteByNumber(String number);

    Optional<Contact> findContactByNumber(String email);
}
