package com.Ejadatraining.Librarysystem.controller;

import com.Ejadatraining.Librarysystem.entity.Borrow;
import com.Ejadatraining.Librarysystem.service.BorrowService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aalsaqqa
//
 */
@RestController
@RequestMapping("/api/Borrow")
public class BorrowController {

    private BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }
    @RequestMapping("/getAllBorrows")
    public List<Borrow> getAllBorrows() {
        return borrowService.findAll();
    }
    @RequestMapping("/getBorrowByIdOrUserIdOrBookId")
    @ResponseBody
    public Borrow getBorrowByIdOrUserIdOrBookId(
            @RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "userId", required = false) Integer userId,
            @RequestParam(name = "bookId", required = false) Integer bookId
    ) {
        return this.borrowService.getBorrowByIdOrUserIdOrBookId(id, userId, bookId);
    }
    @PostMapping("/addBorrow")
    @ResponseBody
    public void addBorrow(@RequestParam(name = "borrow") Borrow borrow) {
        this.borrowService.addBorrow(borrow);
    }
    @RequestMapping("/updateBorrow")
    @ResponseBody
    public void updateBorrow(@RequestParam(name = "borrow") Borrow borrow) {
        this.borrowService.updateBorrow(borrow);
    }
    @RequestMapping("/deleteBorrow")
    @ResponseBody
    public void deleteBorrow(@RequestParam(name = "id") Integer id) {
        this.borrowService.deleteBorrow(id);
    }
}
