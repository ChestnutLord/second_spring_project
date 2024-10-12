package com.example.springtodolist.impl;

import com.example.springtodolist.model.Contact;
import com.example.springtodolist.repositiry.InMemoryContactDAO;
import com.example.springtodolist.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryContactServiceImpl implements ContactService {
    private final InMemoryContactDAO REPOSITORY ;

    @Override
    public List<Contact> getAllContacts(){
        return REPOSITORY.getAllContact();
    }

    @Override
    public Contact getByNumber(String number) {return REPOSITORY.findByNumber(number);}

    @Override
    public Contact saveContact(Contact contact) {
        return REPOSITORY.saveContact(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return REPOSITORY.updateContact(contact);
    }

    @Override
    public void deleteContact(String number) {
        REPOSITORY.deleteContact(number);
    }

}
