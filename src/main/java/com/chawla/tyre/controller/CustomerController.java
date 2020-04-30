package com.chawla.tyre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.chawla.tyre.entity.Customer;
import com.chawla.tyre.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("/addCustomer")
	public String addCustomer() {
		return "addCustomer";
	}

	@GetMapping("/viewCustomer")
	public String viewCustomer() {
		return "customerQuery";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(Customer customer) {
		customer = service.save(customer);
		if (customer != null) {
			return "viewDetails";
		} else {
			return "failed";
		}
	}

	@GetMapping("/findCustomer")
	public String findCustomer(Customer customer, Model model) {
		List<Customer> customers = service.findCustomers(customer);
		model.addAttribute("customers", customers);
		return "viewCustomer";
	}
}
