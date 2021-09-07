package com.sillycat.springboot.restfulapi.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sillycat.springboot.restfulapi.model.CustomerDTO;
import com.sillycat.springboot.restfulapi.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(value = "/api/customers/")
@RestController
@RequestMapping("/api/customers")
@Slf4j
public class CustomerController {

	@Resource(name = "customerService")
	private CustomerService customerService;

	@ApiOperation(value = "Load All Customers", response = com.sillycat.springboot.restfulapi.model.CustomerDTO.class)
	@GetMapping
	public List<CustomerDTO> getCustomers() {
		log.info("getCustomers method invoke---------");
		return customerService.getAllCustomers();
	}

	@ApiOperation(value = "Get One Customer", response = com.sillycat.springboot.restfulapi.model.CustomerDTO.class)
	@GetMapping("/{id}")
	public CustomerDTO getCustomer(@PathVariable Long id) {
		log.info("getCustomer method invoke---------");
		return customerService.getCustomerById(id);
	}

	@ApiOperation(value = "Create One Customer")
	@PostMapping("/")
	public CustomerDTO saveCustomer(final @RequestBody CustomerDTO customerData) {
		log.info("saveCustomer method invoke---------");
		return customerService.saveCustomer(customerData);
	}

	@ApiOperation(value = "Delete One Customer")
	@DeleteMapping("/{id}")
	public Boolean deleteCustomer(@PathVariable Long id) {
		log.info("deleteCustomer method invoke---------");
		return customerService.deleteCustomer(id);
	}
}
