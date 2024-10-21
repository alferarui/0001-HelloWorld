package be.abis.helloworld;

import be.abis.helloworld.model.Person;
import be.abis.helloworld.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloWorldApplicationTests {

	@Autowired
	PersonService personService;

	@Test
	void contextLoads() {
	}

	@Test
	void testPersonServiceFindById(){
		Person p = personService.getPersonById(1L);
		System.out.println(p);
	}

}
