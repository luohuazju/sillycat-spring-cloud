package com.sillycat.springboot.restfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sillycat.springboot.restfulapi.model.Person;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Long> {

}
