package com.Ejadatraining.Librarysystem.service;

import com.Ejadatraining.Librarysystem.dao.BorrowDAO;
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

}
