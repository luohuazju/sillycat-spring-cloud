package com.sillycat.springboot.restfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sillycat.springboot.restfulapi.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
