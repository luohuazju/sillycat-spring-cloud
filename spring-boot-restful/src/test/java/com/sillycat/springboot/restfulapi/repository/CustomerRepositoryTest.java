package com.sillycat.springboot.restfulapi.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.sillycat.springboot.restfulapi.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void testBeanNotNull() {
		log.info("testBeanNotNull invoke------");
		Assert.notNull(customerRepository, "customerRepository can not be null during unit testing");
	}

	@Test
	public void testLoadAll() {
		List<Customer> items = customerRepository.findAll();
		Assert.isTrue(items.size() > 0, "load all not empty, we have default Hua Luo there");
	}

	@Test
	public void testFindById() {
		Optional<Customer> itemOptional = customerRepository.findById(Long.valueOf(2));
		log.info("getById invoke get item: " + itemOptional.get().toString());
		Assert.notNull(itemOptional.get(), "Default value should be there");
		;
	}

	@Test
	public void testFindByFirstName() {
		List<Customer> items = customerRepository.findByFirstName("Hua");
		Assert.notNull(items, "should have firstname Hua");
		log.info("find hua: " + items.get(0).toString());
	}

	@Test
	public void testFindByFirstNameAndLastName() {
		List<Customer> items = customerRepository.findByFirstNameAndLastName("Hua", "Luo");
		Assert.notNull(items, "should have firstname Hua lastname Luo");
		log.info("find hua luo: " + items.get(0).toString());
	}

	@Test
	public void testGetCustomerByFirstNameAndLastName() {
		List<Customer> items = customerRepository.findCustomerByFirstNameAndLastName("Hua", "Luo");
		Assert.notNull(items, "should have firstname Hua lastname Luo");
		log.info("find hua luo in query: " + items.get(0).toString());
	}

	@Test
	public void testGetCustomerByFirstName() {
		List<Customer> items = customerRepository.findCustomerByFirstName("Hua");
		Assert.notNull(items, "should have firstname Hua lastname Luo");
		log.info("find hua luo in query: " + items.get(0).toString());
	}

}