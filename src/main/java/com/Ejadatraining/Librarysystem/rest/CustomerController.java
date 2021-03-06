package com.Ejadatraining.Librarysystem.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ejadatraining.Librarysystem.entity.Customer;
import com.Ejadatraining.Librarysystem.entity.CustomerBorrowCount;
import com.Ejadatraining.Librarysystem.service.BorrowService;
import com.Ejadatraining.Librarysystem.service.CustomerService;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/Customer")
public class CustomerController {

    private CustomerService customerService;
    private BorrowService borrowService;

    @Autowired
    public CustomerController(CustomerService customerService, BorrowService borrowService) {
        this.customerService = customerService;
        this.borrowService = borrowService;
    }

    @RequestMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {
        List<Customer> a = this.customerService.findAll();
        return a;
    }

    @RequestMapping("/getAllCustomersWithBorrowCount")
    public List<CustomerBorrowCount> getAllCustomersWithBorrowCount() {
        List<Customer> customers = this.customerService.findAll();
        ArrayList<CustomerBorrowCount> res = new ArrayList<>();

        for (Customer customer : customers) {
            res.add(new CustomerBorrowCount(customer, borrowService.getCountByCustomerId(customer.getId())));
        }
        return res;
    }

    @GetMapping("/getCustomerByIdOrName")
    @ResponseBody
    public Customer getCustomerByIdOrName(@RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "customername", required = false) String customerName) {
        return this.customerService.getCustomerByIdOrName(id, customerName);
    }

    @PostMapping("/createCustomer")
    @ResponseBody
    public void createCustomer(@RequestParam HashMap<String, String> param) {
        Customer customer = new Customer(0, param.get("name"), param.get("phoneNumber"),
                Boolean.parseBoolean(param.get("enabled")), param.get("password"), param.get("username"));
        this.customerService.createCustomer(customer);
    }

    @PostMapping("/updateCustomer")
    @ResponseBody
    public void updateCustomer(@RequestBody HashMap<String, String> param) {
        try {
            Customer customer = new Customer(Integer.parseInt(param.get("id")), param.get("name"),
                    param.get("phoneNumber"),
                    Boolean.parseBoolean(param.get("enabled")), param.get("password"), param.get("username"));
            customer.setId(Integer.parseInt(param.get("id")));
            customer.setRole(param.get("role"));
            this.customerService.updateCustomer(customer);
            System.out.println("com.Ejadatraining.Librarysystem.rest.CustomerController.updateCustomer():"
                    + "Successful");
        } catch (Exception e) {
            System.out.println("com.Ejadatraining.Librarysystem.rest.CustomerController.updateCustomer():"
                    + "Failure");
            System.out.println(e.getMessage());
        }

    }

    @GetMapping("/deleteCustomer")
    @ResponseBody
    public void deleteCustomer(@RequestParam(name = "id") int id) {
        this.customerService.deleteCustomer(id);
    }
}
