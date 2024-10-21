package be.abis.helloworld.service;

import be.abis.helloworld.model.Person;

public interface PersonService {
    Person[] getAll();
    Person getPersonById(Long id);
}
