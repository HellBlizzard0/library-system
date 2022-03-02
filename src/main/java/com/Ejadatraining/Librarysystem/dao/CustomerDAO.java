package com.Ejadatraining.Librarysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ejadatraining.Librarysystem.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    public Customer findByName(String name);
}
