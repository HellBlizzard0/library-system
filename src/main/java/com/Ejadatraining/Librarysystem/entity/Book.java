package com.Ejadatraining.Librarysystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author aalsaqqa
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {

    public Book(int id) {
        this.id = id;
    }

    public Book() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDateOfCreation() {
        return dateOfCreation.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getLastUpdate() {
        return lastUpdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getRating() {
        return rating;
    }

    public String getGenres() {
        return genres;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    public Book(int id, String title, String serialNumber, String authorName, String description, int pageCount,
            String rating, String genres) {
        this.id = id;
        this.title = title;
        this.serialNumber = serialNumber;
        this.authorName = authorName;
        this.description = description;
        this.pageCount = pageCount;
        this.rating = rating;
        this.genres = genres;
    }

    @Column(name = "title")
    private String title;

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", serialNumber=" + serialNumber + ", authorName="
                + authorName + ", description=" + description + ", pageCount=" + pageCount + ", rating=" + rating
                + ", genres=" + genres + '}';
    }

    @Column(name = "date_of_creation", updatable = false)
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfCreation;

    @Column(name = "last_updated")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate lastUpdate;

    @Column(name = "ISBN")
    private String serialNumber;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "description")
    private String description;

    @Column(name = "page_count")
    private int pageCount;

    @Column(name = "rating")
    private String rating;

    @Column(name = "genres")
    private String genres;

    public Book(int id, String title, LocalDate dateOfCreation, LocalDate lastUpdate, String serialNumber,
            String authorName, String description, int pageCount, String rating, String genres) {
        this.id = id;
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.lastUpdate = lastUpdate;
        this.serialNumber = serialNumber;
        this.authorName = authorName;
        this.description = description;
        this.pageCount = pageCount;
        this.rating = rating;
        this.genres = genres;
    }

}
