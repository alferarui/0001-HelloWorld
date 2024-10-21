package be.abis.helloworld.service;


import be.abis.helloworld.model.Person;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class AbisPersonService  implements PersonService {
    private final Person[] persons = {
            new Person() {{
                setId(1L);setName("Sandy");setAge(42);
            }},
            new Person() {{
                setId(2L);setName("John Doe");setAge(33);
            }}
    };

    @Override
    public Person[] getAll() {
        return persons;
    }

    @Override
    public Person getPersonById(Long id) {
        for( Person p : persons){
            if (p.getId() == id){
                return p;
            }
        }
        return new Person() {{
            setId(1000L);setName("Nobody");setAge(-1);
        }};
    }
}
