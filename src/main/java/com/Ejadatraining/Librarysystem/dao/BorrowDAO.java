package com.Ejadatraining.Librarysystem.dao;

import com.Ejadatraining.Librarysystem.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author aalsaqqa
 */
public interface BorrowDAO extends JpaRepository<Borrow, Integer> {

    public Borrow findByUserId(Integer userId);

    public Borrow findByBookId(Integer bookId);
}
