package com.example.springtodolist.impl;

import com.example.springtodolist.dto.ContactDTO;
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

    private final ContactRepository repository;

    @Override
    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    @Override
    public Contact getByNumber(String number) {

        return repository.findStudentByNumber(number);
    }

    @Override
    public Contact saveContact(ContactDTO contact) {
        return repository.save(contact);
    }

    @Override
    public Contact updateContact(ContactDTO contactDto) {
        return repository.save(contactDto);
    }

    @Override
    @Transactional
    public void deleteContact(String number) {
        repository.deleteByNumber(number);
    }

}
