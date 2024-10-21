package be.abis.helloworld;

import be.abis.helloworld.model.Person;
import be.abis.helloworld.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PersonsApiController {
    @Autowired
    PersonService personService;

    @GetMapping("/api/persons/all")
    Person[] allPersons() {
        return personService.getAll();
    }

    @GetMapping("/api/persons/{id}")
    Person findPersonbyId(@PathVariable Long id) {
        return personService.getPersonById(id);
    }
}
