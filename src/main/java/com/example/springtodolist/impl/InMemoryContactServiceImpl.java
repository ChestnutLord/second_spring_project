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
    private final InMemoryContactDAO repository;

    @Override
    public List<Contact> getAllContacts() {
        return repository.getAllContact();
    }

    @Override
    public Contact getByNumber(String number) {
        return repository.findByNumber(number);
    }

    @Override
    public Contact saveContact(Contact contact) {
        return repository.saveContact(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return repository.updateContact(contact);
    }

    @Override
    public void deleteContact(String number) {
        repository.deleteContact(number);
    }

}
