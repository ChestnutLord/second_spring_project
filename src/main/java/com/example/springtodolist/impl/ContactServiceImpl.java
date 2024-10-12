package com.example.springtodolist.impl;

import com.example.springtodolist.model.Contact;
import com.example.springtodolist.repositiry.ContactRepository;
import com.example.springtodolist.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class ContactServiceImpl implements ContactService {

    private final ContactRepository REPOSITORY;
    @Override
    public List<Contact> getAllContacts() {
        return REPOSITORY.findAll();
    }

    @Override
    public Contact getByNumber(String number) {
        return REPOSITORY.findStudentByNumber(number);
    }

    @Override
    public Contact saveContact(Contact contact) {
        return REPOSITORY.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return REPOSITORY.save(contact);
    }

    @Override
    @Transactional
    public void deleteContact(String number) {
        REPOSITORY.deleteByNumber(number);
    }

}
