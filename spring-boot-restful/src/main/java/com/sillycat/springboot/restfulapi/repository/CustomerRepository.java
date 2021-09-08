package com.sillycat.springboot.restfulapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sillycat.springboot.restfulapi.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByFirstName(String firstName);

	List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

	@Query(name = "find_customer_by_first_name_and_last_name")
	List<Customer> findCustomerByFirstNameAndLastName(String firstName, String lastName);

	@Query(name = "find_customer_by_first_name")
	List<Customer> findCustomerByFirstName(String firstName);
}
