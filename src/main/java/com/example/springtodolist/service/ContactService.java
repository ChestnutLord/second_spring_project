package com.example.springtodolist.service;

import com.example.springtodolist.model.Contact;
import com.example.springtodolist.repositiry.ContactRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactService {

    private final ContactRepository repository;

    public List<Contact> findAllContacts() {
        return repository.findAll();
    }

    public Optional<Contact> findByNumber(String number) {
        return repository.findByNumber(number);
    }

    public Contact saveContact(Contact contact) {
        return repository.save(contact);
    }

    public Contact updateContact(long id, Contact updatedContact) {
        Contact contact = repository.findById(id);
        if (contact != null) {
            contact.setName(updatedContact.getName());
            contact.setNumber(updatedContact.getNumber());
            contact.setAddress(updatedContact.getAddress());
            return repository.save(contact);
        } else {
            throw new EntityNotFoundException("Contact not found with id " + updatedContact.getId());
        }
    }

    @Transactional
    // без аннотации не работалло
    public void deleteContact(String number) {
        repository.deleteByNumber(number);
    }
}
