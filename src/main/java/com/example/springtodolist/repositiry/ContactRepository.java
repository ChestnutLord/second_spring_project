package com.example.springtodolist.repositiry;

import com.example.springtodolist.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactRepository {

    List<Contact> findAll();

    Optional<Contact> findByNumber(String number);

    Contact save(Contact contact);

    Contact findById(long id);

    void deleteByNumber(String number);

}
