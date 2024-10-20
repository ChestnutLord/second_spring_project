package com.example.springtodolist.repositiry;

import com.example.springtodolist.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryContactRepository implements ContactRepository {
    private long id = 0;
    private final List<Contact> contacts = new ArrayList<>();

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public Contact save(Contact contact) {
        if (contact.getId() <= 0) {
            Contact updateContact = findById(contact.getId()).get();
            updateContact.setName(contact.getName());
            updateContact.setNumber(contact.getNumber());
            updateContact.setAddress(contact.getAddress());
            return updateContact;
        }
        id++;
        contact.setId(id);
        contacts.add(contact);
        return contact;

    }

    @Override
    public Optional<Contact> findById(long id) {
        return contacts.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteById(long id) {
        Contact contact = findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contact with id " + id + " not found"));

        contacts.remove(contact);
    }

}
