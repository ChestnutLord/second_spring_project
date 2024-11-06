package com.example.springtodolist.controller;

import com.example.springtodolist.dto.ContactDTO;
import com.example.springtodolist.mapper.ContactMapper;
import com.example.springtodolist.model.Contact;
import com.example.springtodolist.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contacts")
@AllArgsConstructor
public class ContactController {

    private final ContactService service;

    private ContactMapper contactMapper;

    @GetMapping
    public List<ContactDTO> getAllContacts() {
        return contactMapper.toDTOList(service.findAllContacts());
    }

    @GetMapping("/{id}")
    public ContactDTO findById(@PathVariable long id) {
        return contactMapper.toContactDto(service.findById(id));
    }

    @PostMapping
    public ContactDTO saveContact(@RequestBody ContactDTO contact) {
        return contactMapper.toContactDto(service.saveContact(contactMapper.toContact(contact)));
        //return contactMapper.toContactDto(service.saveContact(contact));
    }

    @PutMapping("/{id}")
    public ContactDTO updateContact(@PathVariable long id, @RequestBody ContactDTO contact) {
        return contactMapper.toContactDto(service.updateContact(id, contactMapper.toContact(contact)));
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable long id) {
        service.deleteContact(id);
    }

}