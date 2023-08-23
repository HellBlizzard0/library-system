package com.Ejadatraining.Librarysystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Ejadatraining.Librarysystem.entity.Book;

/**
 *
 * @author aalsaqqa
 */
@Repository
public interface BookDAO extends JpaRepository<Book, Integer> {
    @Query(value = "select * from "
            + "Book b "
            + "where (b.title is null or b.title = ?1) "
            + "or (b.id is null or b.id = ?2) "
            + "or (b.author_name is null or b.author_name = ?3)", nativeQuery = true)
    public List<Book> getBookByNameOrIdOrAuthorname(String title, Integer id, String authorName);
}
