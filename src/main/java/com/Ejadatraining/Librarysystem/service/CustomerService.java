package com.Ejadatraining.Librarysystem.service;

import com.Ejadatraining.Librarysystem.dao.AuthorityDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.Ejadatraining.Librarysystem.dao.CustomerDAO;
import com.Ejadatraining.Librarysystem.entity.Authority;
import com.Ejadatraining.Librarysystem.entity.Customer;

@Service
public class CustomerService {

    private CustomerDAO customerDAO;
    private AuthorityDAO authorityDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO, AuthorityDAO authorityDAO) {
        this.customerDAO = customerDAO;
        this.authorityDAO = authorityDAO;
    }

    public List<Customer> findAll() {
        return this.customerDAO.findAll();
    }

    public Customer getCustomerByIdOrName(Integer id, String customername) {
        return this.customerDAO.findByIdOrName(id, customername);
    }

    @Transactional
    public void createCustomer(Customer customer) {
        this.customerDAO.save(customer);
        Authority a = new Authority(customer.getUsername(), "ROLE_CUSTOMER");
        this.authorityDAO.save(a);
    }

    @Transactional
    public void deleteCustomer(int id) {
        this.customerDAO.deleteById(id);
    }

    @Transactional
    public void updateCustomer(Customer customer) {
        // Get Customer pre-update.
        Customer c = this.customerDAO.findById(customer.getId()).get();
        // Get Authority pre-update.
        Authority a = new Authority(c.getUsername(), "ROLE_CUSTOMER");

        // Update Customer/User entry, hopefully.
        this.customerDAO.save(customer);

        // Remove previous Authority entry.
        this.authorityDAO.delete(this.authorityDAO.getById(customer.getUsername()));
        // Save new authority entry.
        this.authorityDAO.save(a);
    }
}
