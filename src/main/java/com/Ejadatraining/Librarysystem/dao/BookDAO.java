package com.Ejadatraining.Librarysystem.dao;

import com.Ejadatraining.Librarysystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author aalsaqqa
 */
public interface BookDAO extends JpaRepository<Book, Integer> {
}
