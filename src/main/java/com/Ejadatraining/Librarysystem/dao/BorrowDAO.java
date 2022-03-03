package com.Ejadatraining.Librarysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ejadatraining.Librarysystem.entity.Borrow;
import com.Ejadatraining.Librarysystem.entity.Customer;

/**
 *
 * @author aalsaqqa
 */
public interface BorrowDAO extends JpaRepository<Borrow, Integer> {

	// public Borrow findByUserId(Integer userId);

    public Borrow findByBookId(Integer bookId);

    public Borrow findByCustomer(Customer customer);

}
