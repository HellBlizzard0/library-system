/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ejadatraining.Librarysystem.rest;

import com.Ejadatraining.Librarysystem.entity.BookList;
import com.Ejadatraining.Librarysystem.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author aalsaqqa
 */
@RestController
@RequestMapping("/api/Report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping("/print/ar")
    @ResponseBody
    public ResponseEntity<byte[]> printReportAR(@RequestBody BookList bookList) {
        return this.reportService.printReport(bookList.getBookList(), false);
    }

    @RequestMapping("print/en")
    @ResponseBody
    public ResponseEntity<byte[]> printReportEN(@RequestBody BookList bookList) {
        return this.reportService.printReport(bookList.getBookList(), true);
    }

}
