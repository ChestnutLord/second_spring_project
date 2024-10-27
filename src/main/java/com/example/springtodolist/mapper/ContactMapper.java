package com.example.springtodolist.mapper;

import com.example.springtodolist.dto.ContactDTO;
import com.example.springtodolist.model.Contact;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact toContact(ContactDTO contactDto);

    ContactDTO toContactDto(Contact contact);

    List<ContactDTO> toDTOList(List<Contact> contacts);
}
