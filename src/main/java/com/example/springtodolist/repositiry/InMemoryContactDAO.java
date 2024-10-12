package com.example.springtodolist.repositiry;

import com.example.springtodolist.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryContactDAO {

    private final List<Contact> CONTACTS = new ArrayList<>();

    public List<Contact> getAllContact() {
        return CONTACTS;
    }

    public Contact findByNumber(String number) {
        return CONTACTS.stream().
                filter(element -> element.getNumber().equals(number))
                .findFirst()
                .orElse(null);
    }

    public Contact saveContact(Contact contact) {
        CONTACTS.add(contact);
        System.out.println("Контакт добвавлен");
        return contact;
    }

    public Contact updateContact(Contact contact) {
        var contactIndex = IntStream.range(0, CONTACTS.size())
                .filter(index -> CONTACTS.get(index).getId().equals(contact.getId()))
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
            CONTACTS.remove(contact);
            System.out.println("Контакт удалён");
        }
    }

}
