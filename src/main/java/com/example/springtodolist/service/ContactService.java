package com.example.springtodolist.service;

import com.example.springtodolist.dto.ContactDTO;
import com.example.springtodolist.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getAllContacts();

    Contact getByNumber(String number);

    Contact saveContact(ContactDTO contactDto);

    Contact updateContact(ContactDTO contactDto);

    void deleteContact(String number);

}
