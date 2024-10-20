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

    public Contact findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
    }

    public Contact saveContact(Contact contact) {
        return repository.save(contact);
    }

    public Contact updateContact(long id, Contact updatedContact) {
        return repository.findById(id)
                .map(contact -> {
                    contact.setName(updatedContact.getName());
                    contact.setNumber(updatedContact.getNumber());
                    contact.setAddress(updatedContact.getAddress());
                    return repository.save(contact);
                })
                .orElseThrow(() -> new EntityNotFoundException("Contact not found with id " + id));
    }

    public void deleteContact(long id) {
        repository.deleteById(id);
    }

}
