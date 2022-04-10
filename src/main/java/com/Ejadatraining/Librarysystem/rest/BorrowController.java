package com.Ejadatraining.Librarysystem.rest;

import com.Ejadatraining.Librarysystem.entity.Borrow;
import com.Ejadatraining.Librarysystem.entity.BorrowStatus;
import com.Ejadatraining.Librarysystem.service.BorrowService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @GetMapping("/getAllBorrows")
    public List<Borrow> getAllBorrows() {
        return borrowService.findAll();
    }
    @GetMapping("/getBorrowByIdOrUserIdOrBookId")
    @ResponseBody
    public Borrow getBorrowByIdOrUserIdOrBookId(
            @RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "userId", required = false) Integer userId,
            @RequestParam(name = "bookId", required = false) Integer bookId
    ) {
        return this.borrowService.getBorrowByIdOrUserIdOrBookId(id, userId, bookId);
    }

    @GetMapping("/getBorrowByUserId")
    public List<Borrow> getBorrowByUserId(@RequestParam(name = "id") int id) {
        return this.borrowService.findById(id);
    }
    @Deprecated(since = "2022/9/4", forRemoval = true)
    @PostMapping("/addBorrow")
    @ResponseBody
    public void addBorrow(@RequestBody Borrow borrow) {
        //this.borrowService.addBorrow(borrow);
    }
    @PostMapping("/updateBorrow")
    @ResponseBody
    public void updateBorrow(@RequestBody Borrow borrow) {
        this.borrowService.updateBorrow(borrow);
    }
    @GetMapping("/deleteBorrow")
    @ResponseBody
    public void deleteBorrow(@RequestParam(name = "id") Integer id) {
        this.borrowService.deleteBorrow(id);
    }


    @PostMapping("/requestBook")
    @ResponseBody
    public boolean requestBorrow(@RequestBody HashMap<String, String> p) {
        Borrow borrow = Borrow.newRequets(p);
        try {
            this.borrowService.addBorrow(borrow);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/acceptRequest")
    @ResponseBody
    public boolean acceptRequest(@RequestBody HashMap<String, String> p) {
        try {
            this.borrowService.acceptRequest(Integer.parseInt(p.get("id")));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/rejectRequest")
    @ResponseBody
    public boolean rejectRequest(@RequestBody HashMap<String, String> p) {
        try {
            this.borrowService.rejectRequest(Integer.parseInt(p.get("id")));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
