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
    public List<ContactDTO> getAllTasks() {
        return contactMapper.toDTOList(service.getAllContacts());
    }

    @GetMapping("/{number}")
    public ContactDTO findByNumber(@PathVariable String number) {
        return contactMapper.toContactDto(service.getByNumber(number));
    }

    @PostMapping("save_contact")
    public Contact saveContact(@RequestBody ContactDTO contactDto) {
        return service.saveContact(contactMapper.toContact(contactDto));
    }

    @PutMapping("update_contact")
    public Contact updateContact(@RequestBody ContactDTO contactDto) {
        return service.updateContact(contactMapper.toContact(contactDto));
    }

    @DeleteMapping("delete_contact/{number}")
    public void deleteContact(@PathVariable String number) {
        service.deleteContact(number);
    }

}