package com.example.springtodolist.repositiry;

import com.example.springtodolist.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Repository
public class InMemoryContactRepository implements ContactRepository {
    private final List<Contact> contacts = new ArrayList<>();

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public Optional<Contact> findByNumber(String number) {
        return contacts.stream().
                filter(element -> element.getNumber().equals(number))
                .findFirst();
    }

    @Override
    public Contact save(Contact contact) {
        contacts.add(contact);
        return contact;
    }

    @Override
    public Contact findById(long id) {
        return contacts.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteByNumber(String number) {
        Contact contact = findByNumber(number)
                .orElseThrow(() -> new IllegalArgumentException("Contact with number " + number + " not found"));

        contacts.remove(contact);
    }

}
