package com.eyallupu.blog.springmvc.controller;
import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eyallupu.blog.springmvc.model.Customer;

@Controller
@RequestMapping("/listAndDetails")
public class SampleListAndDetailsController {

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public Collection<Customer> listAll() {
		return Collections.emptyList();
	}
}
