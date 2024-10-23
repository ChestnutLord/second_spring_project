package com.example.springtodolist.repositiry;

import com.example.springtodolist.dto.ContactDTO;
import com.example.springtodolist.mapper.ContactMapper;
import com.example.springtodolist.model.Contact;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
@AllArgsConstructor
public class InMemoryContactDAO {

    private final List<Contact> CONTACTS = new ArrayList<>();

    private ContactMapper contactMapper;

    public ListDTO<Contact> getAllContact() {
        return CONTACTS;
    }

    public ContactDTO findByNumber(String number) {
        return CONTACTS.stream().
                filter(element -> element.getNumber().equals(number))
                .findFirst()
                .orElse(null);
    }

    public Contact saveContact(ContactDTO contactDto) {
        CONTACTS.add(contactDto);
        System.out.println("Контакт добвавлен");
        return contact;
    }

    public Contact updateContact(ContactDTO contactDto) {
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
