package com.Ejadatraining.Librarysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Ejadatraining.Librarysystem.dao.CustomerDAO;
import com.Ejadatraining.Librarysystem.entity.Customer;

@Repository
public class CustomerService {
	private CustomerDAO customerDAO;

	@Autowired
	public CustomerService(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
    }

	public List<Customer> findAll() {
		return this.customerDAO.findAll();
	}

	public Customer getCustomerByIdOrName(Integer id, String customername) {
		Customer customer;
		if (id != null) {
			customer = this.customerDAO.findById(id).get();
			if (customer != null) {
				return customer;
			}
		}
		if (customername != null) {
			customer = this.customerDAO.findByName(customername);
			if (customer != null) {
				return customer;
			}
		}
		return null;
	}

	@Transactional
	public void createCustomer(Customer customer) {
		this.customerDAO.save(customer);
	}

	@Transactional
	public void deleteCustomer(int id) {
		this.customerDAO.deleteById(id);
	}

	@Transactional
	public void updateCustomer(Customer customer) {
		this.customerDAO.save(customer);
	}
}
