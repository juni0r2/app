package com.schoolofnet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoolofnet.entity.Customer;
import com.schoolofnet.entity.repository.CustomerRepository;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	public CustomerController(CustomerRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	@ResponseBody
	public Customer create(@RequestParam String name, @RequestParam Integer age) {
		return repository.save(new Customer(name, age));
	}

	@GetMapping
	@ResponseBody
	public List<Customer> findAll() {
		return (List<Customer>) repository.findAll();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Customer findById(@PathVariable Long id) {
		return repository.findById(id).get();
	}

	@GetMapping("/name/{name}")
	@ResponseBody
	public Customer findByName(@PathVariable String name) {
		return repository.findByName(name);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void destroy(@PathVariable Long id) {
		repository.delete(repository.findById(id).orElse(null));
	}

}
