package com.example.springtodolist.controller;

import com.example.springtodolist.model.Contact;
import com.example.springtodolist.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/contacts")
@AllArgsConstructor
public class ContactController {

    private final ContactService service;

    @GetMapping
    public List<Contact> getAllContacts() {
        return service.findAllContacts();
    }

    @GetMapping("/{id}")
    public Contact findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PostMapping
    public Contact saveContact(@RequestBody Contact contact) {
        return service.saveContact(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable long id, @RequestBody Contact contact) {
        return service.updateContact(id, contact);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable long id) {
        service.deleteContact(id);
    }

}