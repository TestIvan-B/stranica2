package com.example.demo.service;

import com.example.demo.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
    List<Person> getAllPersons();

    void savePerson(Person person);

    Person getPersonById(long id);

    void deletePersonById(long id);
}

