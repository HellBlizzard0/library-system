package com.Ejadatraining.Librarysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ejadatraining.Librarysystem.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {

	Customer findByName(String customername);

}
