package com.eyallupu.blog.springmvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eyallupu.blog.springmvc.model.Customer;
import com.eyallupu.blog.springmvc.services.CustomersService;

@Controller
@RequestMapping("/customers")
public class CustomersController {

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView listAll() {
		return new ModelAndView("customersList", "customers", CustomersService.instance.getAll());
	}

	@RequestMapping(value="edit", method=RequestMethod.GET	)
	public ModelAndView prepareEdit(String id) {
		Customer customer = CustomersService.instance.loadById(id);
		return new ModelAndView("customerDetails", "customer", customer);
	}
}
