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

	@PostMapping("/getLibrarianByIdOrName")
	@ResponseBody
	public Librarian getLibrarianByIdOrName(@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "librarianname", required = false) String librarianName) {
		return this.librarianService.getLibrarianByIdOrName(id, librarianName);
	}

	@PostMapping("/createLibrarian")
	@ResponseBody
	public void createLibrarian(@RequestParam(name = "librarian") Librarian librarian) {
		this.librarianService.createLibrarian(librarian);
	}

	@RequestMapping("/updateLibrarian")
	@ResponseBody
	public void updateLibrarian(@RequestParam(name = "librarian") Librarian librarian) {
		this.librarianService.updateLibrarian(librarian);
	}

	@RequestMapping("/deleteLibrarian")
	@ResponseBody
	public void deleteLibrarian(@RequestParam(name = "id") int id) {
		this.librarianService.deleteLibrarian(id);
	}
}
