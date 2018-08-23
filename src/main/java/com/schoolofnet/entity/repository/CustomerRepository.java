package com.schoolofnet.entity.repository;

import org.springframework.data.repository.CrudRepository;

import com.schoolofnet.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

	Customer findByName(String name);

}
