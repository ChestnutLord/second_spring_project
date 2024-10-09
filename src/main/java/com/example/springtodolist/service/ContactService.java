package com.example.springtodolist.service;

import com.example.springtodolist.model.Contact;
import org.springframework.stereotype.Service;
import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    Contact getByNumber(String number);
    Contact saveContact(Contact contact);
    Contact updateContact(Contact contact);
    void deleteContact(String number);

}
