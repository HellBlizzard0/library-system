package com.Ejadatraining.Librarysystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author aalsaqqa
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {

    public Book() {
    }

    public Book(int id, String title, LocalDateTime dateOfCreation, LocalDateTime lastUpdate, String serialNumber, String authorName, String description, Number pageCount, String rating, String genres) {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
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

    public void setPageCount(Number pageCount) {
        this.pageCount = pageCount;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
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

    public Number getPageCount() {
        return pageCount;
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
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date_of_creation", updatable = false)
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime dateOfCreation;

    @Column(name = "last_updated")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime lastUpdate;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "author_name")
    private String authorName;
    
    @Column(name = "description")
    private String description;
    
    
    @Column(name = "page_count")
    private Number pageCount;
    
    
    @Column(name = "rating")
    private String rating;
    
    
    @Column(name = "genres")
    private String genres;

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", dateOfCreation=" + dateOfCreation + ", lastUpdate=" + lastUpdate + ", serialNumber=" + serialNumber + ", authorName=" + authorName + ", description=" + description + ", pageCount=" + pageCount + ", rating=" + rating + ", genres=" + genres + '}';
    }
    
    

}
