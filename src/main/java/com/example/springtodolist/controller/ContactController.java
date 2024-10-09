package com.example.springtodolist.controller;

import com.example.springtodolist.model.Contact;
import com.example.springtodolist.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api.v1.contacts")
@AllArgsConstructor
public class ContactController {
    private final ContactService service;


    @GetMapping
    public List<Contact> getAllTasks() {
        return service.getAllContacts();
    }
    @GetMapping("/{number}")
    public Contact findByNumber(@PathVariable String number) {
        return service.getByNumber(number);
    }

    @PostMapping("save_contact")
    public Contact saveContact(@RequestBody Contact contact) {
        return service.saveContact(contact);
    }

    @PutMapping("update_contact")
    public Contact updateContact(@RequestBody Contact contact) {
        return service.updateContact(contact);
    }

    @DeleteMapping("delete_contact/{number}")
    public void deleteContact(@PathVariable String number) {
        service.deleteContact(number);
    }
}