package com.sillycat.springboot.restfulapi.repository;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.sillycat.springboot.restfulapi.model.Address;
import com.sillycat.springboot.restfulapi.model.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PersonRepositoryTest {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Test
	public void testBeanNotNull() {
		log.info("testBeanNotNull invoke------");
		Assert.notNull(personRepository, "personRepository can not be null during unit testing");
	}
	
	//@Test
	public void testSave() {
		Person p = new Person();
		p.setAge(30);
		p.setUsername("luohuazju_" + new Date().getTime());
		personRepository.save(p);
		
		Address a = new Address();
		a.setAddress("4210 " + new Date().getTime());
		a.setName("Home");
		a.setPersonId(p.getId());
		addressRepository.save(a);
	}
	
	//@Test
	public void testFindById() {
		Optional<Person> p = personRepository.findById(Long.valueOf(1));
		Assert.notNull(p.get(), "Person should be there");
		log.info("The address info is: " + p.get().getAddress());
	}

}
