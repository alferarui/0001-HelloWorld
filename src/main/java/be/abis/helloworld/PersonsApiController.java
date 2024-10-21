package be.abis.helloworld;

import be.abis.helloworld.model.Person;
import be.abis.helloworld.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class PersonsApiController {
    @Autowired
    PersonService personService;

    @GetMapping("/api/persons")
    List<Person> allPersons() {
        return personService.getAll();
    }

    @GetMapping("/api/persons/{id}")
    Person findPersonbyId(@PathVariable Long id) {
        return personService.getPersonById(id);
    }
    @PatchMapping("/api/persons/{id}/deactivate")
    Person deactivate(@PathVariable Long id) {
        return personService.deactivate(id);
    }
    @PatchMapping("/api/persons/{id}/activate")
    Person activate(@PathVariable Long id) {
        return personService.activate(id);
    }
    @PostMapping("/api/persons")
    Person activate(@RequestBody Person p) {
        return personService.save(p);
    }
}
