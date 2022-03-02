package com.Ejadatraining.Librarysystem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ejadatraining.Librarysystem.entity.Librarian;
import com.Ejadatraining.Librarysystem.service.LibrarianService;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/Librarian")

public class LibrarianController {

    private LibrarianService librarianService;

    @Autowired
    public LibrarianController(LibrarianService librarianService) {
        super();
        this.librarianService = librarianService;
    }

    @RequestMapping("/getAllLibrarians")
    public List<Librarian> getAllLibrarians() {
        return this.librarianService.findAll();
    }

    @GetMapping("/getLibrarianByIdOrName")
    @ResponseBody
    public Librarian getLibrarianByIdOrName(@RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "librarianname", required = false) String librarianName) {
        return this.librarianService.getLibrarianByIdOrName(id, librarianName);
    }

    @PostMapping("/createLibrarian")
    @ResponseBody
    public void createLibrarian(@RequestParam HashMap<String, String> param) {
        Librarian librarian = new Librarian(0, Boolean.parseBoolean(param.get("enabled")), param.get("password"), param.get("username"), param.get("name"));
        this.librarianService.createLibrarian(librarian);
    }

    @PostMapping("/updateLibrarian")
    @ResponseBody
    public void updateLibrarian(@RequestParam(name = "librarian") HashMap<String, String> param) {
        Librarian librarian = new Librarian(Integer.parseInt(param.get("id")), Boolean.parseBoolean(param.get("enabled")), param.get("password"), param.get("username"), param.get("name"));

        this.librarianService.updateLibrarian(librarian);
    }

    @GetMapping("/deleteLibrarian")
    @ResponseBody
    public void deleteLibrarian(@RequestParam(name = "id") int id) {
        this.librarianService.deleteLibrarian(id);
    }
}
