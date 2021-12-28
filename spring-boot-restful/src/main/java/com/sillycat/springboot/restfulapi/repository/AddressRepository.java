package com.sillycat.springboot.restfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sillycat.springboot.restfulapi.model.Address;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Long> {

}
