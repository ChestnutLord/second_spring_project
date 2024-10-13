package com.example.springtodolist.repositiry;

import com.example.springtodolist.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Repository
public class InMemoryContactDAO implements ContactRepository {

    private final List<Contact> contacts = new ArrayList<>();

    public List<Contact> getAllContact() {
        return contacts;
    }

    public Contact findByNumber(String number) {
        return contacts.stream().
                filter(element -> element.getNumber().equals(number))
                .findFirst()
                .orElse(null);
    }

    public Contact saveContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Контакт добвавлен");
        return contact;
    }

    public Contact updateContact(Contact contact) {
        var contactIndex = IntStream.range(0, contacts.size())
                .filter(index -> contacts.get(index).getId().equals(contact.getId()))
                .findFirst()
                .orElse(-1);
        if (contactIndex > -1) {
            CONTACTS.set(contactIndex, contact);
        }
        return contact;
    }

    public void deleteContact(String number) {
        var contact = findByNumber(number);
        if (contact != null) {
            contacts.remove(contact);
            System.out.println("Контакт удалён");
        }
    }

    @Override
    public void deleteByNumber(String number) {
        var contact = findContactByNumber(number);
        if (contact != null) {
            contacts.remove(contact);
            System.out.println("Контакт удалён");
        }
    }

    @Override
    public Optional<Contact> findContactByNumber(String number) {
        return Optional.ofNullable(contacts.stream().
                filter(element -> element.getNumber().equals(number))
                .findFirst()
                .orElse(null));
    }
}
