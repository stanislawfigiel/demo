package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Transactional
	public Page<Customer> findAll(PageRequest pageRequest){
    return customerRepository.findAll(pageRequest);
	}

	@Transactional
	public Iterable<Customer> findAll(){
		return customerRepository.findAll();
	}

	@Transactional
	public Customer save(Customer customer) {
		return customerRepository.save(customer);

	}

	@Transactional
	public void delete(Customer customer) {
		 customerRepository.delete(customer);

	}

	@Transactional
	public Optional<Customer> findById(Long id) {
		return customerRepository.findById(id);
	}



}
