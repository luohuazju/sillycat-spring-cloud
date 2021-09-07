package com.sillycat.springboot.restfulapi.service;

import java.util.List;

import com.sillycat.springboot.restfulapi.model.CustomerDTO;

public interface CustomerService {

	CustomerDTO saveCustomer(CustomerDTO customerDTO);

	boolean deleteCustomer(final Long customerId);

	List<CustomerDTO> getAllCustomers();

	CustomerDTO getCustomerById(final Long customerId);

}
