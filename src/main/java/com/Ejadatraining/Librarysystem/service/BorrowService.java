package com.Ejadatraining.Librarysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Ejadatraining.Librarysystem.dao.BorrowDAO;
import com.Ejadatraining.Librarysystem.entity.Borrow;
import com.Ejadatraining.Librarysystem.entity.Customer;

/**
 *
 * @author aalsaqqa
 */
@Repository
public class BorrowService {
    private BorrowDAO borrowDAO;

    @Autowired
    public BorrowService(BorrowDAO borrowDAO) {
        this.borrowDAO = borrowDAO;
    }

    public List<Borrow> findAll() {
        return this.borrowDAO.findAll();
    }

    public Borrow getBorrowByIdOrUserIdOrBookId(Integer id, Integer userId, Integer bookId) {
		Borrow borrow = null;
        if (id != null) {
            borrow = this.borrowDAO.findById(id).get();
            if (borrow != null) {
                return borrow;
            }
        }

        if (userId != null) {
            Customer customer = new Customer(userId, "", "", true, "", "");
            borrow = this.borrowDAO.findByCustomer(customer);
            if (borrow != null) {
                return borrow;
            }
        }

        if (bookId != null) {
            borrow = this.borrowDAO.findByBookId(bookId);
            if (borrow != null) {
                return borrow;
            }
        }

        return null;
    }
    @Transactional
    public void deleteBorrow(Integer id) {
        this.borrowDAO.deleteById(id);
    }
    @Transactional
    public void addBorrow(Borrow borrow) {
        this.borrowDAO.save(borrow);
    }
    @Transactional
    public void updateBorrow(Borrow borrow) {
        this.borrowDAO.save(borrow);
    }
}
