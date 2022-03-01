package com.Ejadatraining.Librarysystem.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ejadatraining.Librarysystem.entity.Customer;
import com.Ejadatraining.Librarysystem.service.CustomerService;

@RestController
@RequestMapping("/api/Customer")
public class CustomerController {
	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@RequestMapping("/getAllCustomers")
	public List<Customer> getAllCustomers() {
		List<Customer> a = this.customerService.findAll();
		return a;
	}

	@PostMapping("/getCustomerByIdOrName")
	@ResponseBody
	public Customer getCustomerByIdOrName(@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "customername", required = false) String customerName) {
		return this.customerService.getCustomerByIdOrName(id, customerName);
	}

	@RequestMapping("/createCustomer")
	@ResponseBody
	public void createCustomer(@RequestParam HashMap<String, String> param) {
		System.out.println(param);
		Customer customer = new Customer(param.get("name"), param.get("phoneNumber"),
				Boolean.parseBoolean(param.get("enabled")), param.get("password"), param.get("username"));
		this.customerService.createCustomer(customer);
	}

	@RequestMapping("/updateCustomer")
	@ResponseBody
	public void updateCustomer(@RequestParam Customer customer) {
		this.customerService.updateCustomer(customer);
	}

	@RequestMapping("/deleteCustomer")
	@ResponseBody
	public void deleteCustomer(@RequestParam(name = "id") int id) {
		this.customerService.deleteCustomer(id);
	}
}
