package com.Ejadatraining.Librarysystem.service;

import com.Ejadatraining.Librarysystem.dao.BorrowDAO;
import com.Ejadatraining.Librarysystem.entity.Book;
import com.Ejadatraining.Librarysystem.entity.Borrow;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        Borrow borrow;
        if (id != null) {
            borrow = this.borrowDAO.findById(id).get();
            if (borrow != null) {
                return borrow;
            }
        }

        if (userId != null) {
            borrow = this.borrowDAO.findByUserId(userId);
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

    public void deleteBorrow(Integer id) {
        this.borrowDAO.deleteById(id);
    }

    public void addBorrow(Borrow borrow) {
        this.borrowDAO.save(borrow);
    }

}
