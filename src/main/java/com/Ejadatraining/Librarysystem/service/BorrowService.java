package com.Ejadatraining.Librarysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Ejadatraining.Librarysystem.dao.BorrowDAO;
import com.Ejadatraining.Librarysystem.entity.Borrow;
import com.Ejadatraining.Librarysystem.entity.BorrowStatus;
import java.util.Optional;

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
        return this.borrowDAO.findBorrowByIdOrUserIdOrBookId(id, userId, bookId
        );
    }
    @Transactional
    public void deleteBorrow(Integer id) {
        this.borrowDAO.deleteById(id);
    }
    @Transactional
    public void addBorrow(Borrow borrow) throws Exception {

        for (Borrow b : this.borrowDAO.checkBorrow(borrow.getBook().getId())) {
            if (BorrowStatus.isBorrowed(b.getStatus())) {
                throw new Exception("Book Already Borrowed");
            }
        }
        this.borrowDAO.save(borrow);
    }
    @Transactional
    public void updateBorrow(Borrow borrow) {
        this.borrowDAO.save(borrow);
    }

    public List<Borrow> findById(int id) {
        return this.borrowDAO.findByUserId(id);
    }

    @Transactional
    public void acceptRequest(int id) {
        Borrow borrow = this.borrowDAO.findById(id).get();
        borrow.setStatus(new BorrowStatus(1, "borrowed"));
        this.updateBorrow(borrow);
    }

    @Transactional
    public void rejectRequest(int id) {
        Borrow borrow = this.borrowDAO.findById(id).get();
        this.borrowDAO.delete(borrow);
    }

}
