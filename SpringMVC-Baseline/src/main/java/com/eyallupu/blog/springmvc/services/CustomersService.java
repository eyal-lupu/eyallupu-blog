package com.eyallupu.blog.springmvc.services;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.eyallupu.blog.springmvc.model.Customer;

public class CustomersService {

	private Map<String, Customer> customers = new HashMap<String, Customer>();

	public final static CustomersService instance = new CustomersService();

	{
		for (int t=0; t<10; ++t) {
			Customer customer = new Customer();
			customer.setFirstName("First name " + t);
			customer.setLastName("Last name " + t);
			customers.put(customer.getId(), customer);
		}
	}

	public Collection<Customer> getAll() {
		return Collections.unmodifiableCollection(customers.values());
	}

	public Customer loadById(String id) {
		return customers.get(id);
	}
	private CustomersService() {}
}
