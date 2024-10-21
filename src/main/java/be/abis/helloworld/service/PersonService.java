package be.abis.helloworld.service;

import be.abis.helloworld.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAll();
    Person getPersonById(Long id);
    Person save(Person p);
    Person deactivate(Long id);
    Person activate(Long id);
}
