package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.error.StudentNotFoundException;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/customers")
	Iterable<Customer> getCustomers(){
		return customerService.findAll();

	}

	@GetMapping("/customers/{id}")
	Customer getCustomers(@PathVariable Long id){

		Optional<Customer> customerOpt = customerService.findById(id);

		if(customerOpt.isPresent()) {
			return customerService.findById(id).get();
		} else{
			throw new StudentNotFoundException("");
		}

	}

	@PostMapping("/customers")
	Customer addCustomer(@RequestBody Customer customer){
		customerService.save(customer);

		return customer;
	}

	@PutMapping("/customers")
	Customer updateCustomer(@RequestBody Customer customer){
		customerService.save(customer);

		return customer;
	}

	@DeleteMapping("customers/{customerId}")
	String deleteCustomer(@PathVariable long customerId){
		Optional<Customer> customer = customerService.findById(customerId);

		if(customer.isPresent()){
			customerService.delete(customer.get());
			return String.format("Customer deleted with id: %d", customerId);
		}
		else throw new StudentNotFoundException(String.format("Customer not found with id: %d", customerId));

	}

}
