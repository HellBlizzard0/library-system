package com.Ejadatraining.Librarysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ejadatraining.Librarysystem.entity.Customer;
import org.springframework.data.jpa.repository.Query;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    public Customer findByName(String name);

    @Query(value = "select * from "
            + "Customer c "
            + "where (c.id is null or c.id = ?1) "
            + "or (c.name is null or c.name = ?2) ", nativeQuery = true)
    public Customer findByIdOrName(Integer id, String name);
}
