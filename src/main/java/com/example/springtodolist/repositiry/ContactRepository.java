package com.example.springtodolist.repositiry;

import com.example.springtodolist.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactRepository {

    List<Contact> findAll();

    Contact save(Contact contact);

    Optional<Contact> findById(long id);

    void deleteById(long id);

}
