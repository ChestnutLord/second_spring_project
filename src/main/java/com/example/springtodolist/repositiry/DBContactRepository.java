package com.example.springtodolist.repositiry;

import com.example.springtodolist.model.Contact;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Primary //TODO use from profiles
@Repository
public interface DBContactRepository extends JpaRepository<Contact, Long>, ContactRepository {

    Optional<Contact> findByNumber(String number);

    void deleteByNumber(String number);

}