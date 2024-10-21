package be.abis.helloworld.service;


import be.abis.helloworld.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.rmi.server.LogStream.log;

@Component
public class AbisPersonService  implements PersonService {
    private static final Logger log = LoggerFactory.getLogger(AbisPersonService.class);
    private static ArrayList<Person> persons = new ArrayList<>() {{
                add( new Person() {{
                    setId(1L);
                    setName("Sandy");
                    setAge(42);
                    setIsActive(1);
                }});
                add(new Person() {{
                    setId(2L);
                    setName("John");
                    setAge(31);
                    ;
                    setIsActive(1);
                }});
                add(new Person() {{
                    setId(3L);
                    setName("Paul");
                    setAge(32);
                    ;
                    setIsActive(1);
                }});
                add(new Person() {{
                    setId(4L);
                    setName("Matthew");
                    setAge(33);
                    ;
                    setIsActive(1);
                }});
                add(new Person() {{
                    setId(5L);
                    setName("Peter");
                    setAge(34);
                    ;
                    setIsActive(1);
                }});
    }};
    private Person findById(Long id){
        return persons.stream().filter(person -> Objects.equals(person.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public List<Person> getAll() {
        return persons;
    }

    @Override
    public Person getPersonById(Long id) {
        return Objects.requireNonNullElse(findById(id), Person.NULL);
    }

    @Override
    public Person save(Person p) {
        Person p0 = findById(p.getId());
        if(p0 == null){
            //create
            log("saving");
            log(p.toString());
            p0 = new Person() {{
                setId(persons.size()+1L);
                setName(p.getName());
                setAge(p.getAge());
                setIsActive(0);
            }};
            persons.add(p0);
            return p0;
        } else {
            //update
            p0.setAge(p.getAge());
            p0.setIsActive(p.getIsActive());
            p0.setName(p.getName());
            return p0;
        }
    }

    @Override
    public Person deactivate(Long id) {
        Person p0 = findById(id);
        if(p0 == null){
            return null;
        } else {
            //throw
            p0.setIsActive(0);
            return p0;
        }
    }
    @Override
    public Person activate(Long id) {
        Person p0 = findById(id);
        if(p0 == null){
            //throw
            return null;
        } else {
            //update
            p0.setIsActive(1);
            return p0;
        }
    }
}
