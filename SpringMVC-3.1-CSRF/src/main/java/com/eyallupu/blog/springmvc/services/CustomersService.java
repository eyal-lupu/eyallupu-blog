package com.eyallupu.blog.springmvc.services;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.eyallupu.blog.springmvc.model.Customer;

public class CustomersService {

	private final static String[] FIRST_NAMES = {"Sophia","Darla","Louise","Candace","Ed","Cheryl","Cora","Thomas","Christian","Patti","Dixie","Levi"};
	private final static String[] LAST_NAMES = {"Moreno","Jensen","Reid","Burgess","Bates","Casey","Bennett","Moody","Valdez","Hansen",	"Holloway","King","Holmes"};

	private Map<String, Customer> customers = new HashMap<String, Customer>();

	public final static CustomersService instance = new CustomersService();

	{
		for (int t=0; t<10; ++t) {
			Customer customer = new Customer();
			customer.setFirstName(FIRST_NAMES[(int) (Math.random()*FIRST_NAMES.length)]);
			customer.setLastName(LAST_NAMES[(int) (Math.random()*LAST_NAMES.length)]);
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

	public void save(Customer customer) {
		customers.put(customer.getId(), customer);
	}
}
