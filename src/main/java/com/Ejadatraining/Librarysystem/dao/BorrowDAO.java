package com.Ejadatraining.Librarysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ejadatraining.Librarysystem.entity.Borrow;
import com.Ejadatraining.Librarysystem.entity.Customer;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author aalsaqqa
 */
public interface BorrowDAO extends JpaRepository<Borrow, Integer> {
    @Query(value = "select * from "
            + "Borrow b "
            + "where (b.id is null or b.id = ?1) "
            + "or (b.userId is null or b.userId = ?2) "
            + "or (b.bookId is null or b.bookId = ?3)", nativeQuery = true)
    public Borrow findBorrowByIdOrUserIdOrBookId(Integer id, Integer userId, Integer bookId);
}
