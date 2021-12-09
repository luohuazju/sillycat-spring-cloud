package com.sillycat.springboot.restfulapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sillycat.springboot.restfulapi.model.Customer;
import com.sillycat.springboot.restfulapi.model.CustomerDTO;
import com.sillycat.springboot.restfulapi.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
		Customer customerModel = populateCustomerEntity(customerDTO);
		return populateCustomerDTO(customerRepository.save(customerModel));
	}

	@Override
	public boolean deleteCustomer(Long customerId) {
		customerRepository.deleteById(customerId);
		return true;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<CustomerDTO> customers = new ArrayList<>();
		List<Customer> customerList = customerRepository.findAll();
		customerList.forEach(customer -> {
			customers.add(populateCustomerDTO(customer));
		});
		return customers;
	}

	@Override
	public CustomerDTO getCustomerById(Long customerId) {
		return populateCustomerDTO(customerRepository.findById(customerId)
				.orElseThrow(() -> new EntityNotFoundException("Customer not found")));
	}

	private CustomerDTO populateCustomerDTO(final Customer customer) {
		CustomerDTO dto = new CustomerDTO();
		dto.setId(customer.getId());
		dto.setFirstName(customer.getFirstName());
		dto.setLastName(customer.getLastName());
		dto.setEmail(customer.getEmail());
		return dto;
	}

	private Customer populateCustomerEntity(CustomerDTO dto) {
		Customer customer = new Customer();
		customer.setFirstName(dto.getFirstName());
		customer.setLastName(dto.getLastName());
		customer.setEmail(dto.getEmail());
		return customer;
	}

}
