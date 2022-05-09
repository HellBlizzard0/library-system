/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ejadatraining.Librarysystem.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author aalsaqqa
 */
@Entity
@Table(name = "borrowstatus")
public class BorrowStatus implements Serializable {

    public static boolean isBorrowed(BorrowStatus status) {
        switch (status.id) {
            case RETURNED:
                return false;
            case REQUESTED:
                return false;
            default:
                return true;
        }
    }

    public BorrowStatus() {
    }

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    @Column(name = "status")
    private String status;

    public BorrowStatus(int id) {
        this.id = id;
        switch (id) {
            case BORROWED:
                this.status = "borrowed";
                break;
            case RETURNED:
                this.status = "returned";
                break;
            case OVERDUE:
                this.status = "overdue";
                break;
            case EXTENDED:
                this.status = "extended";
                break;
            case REQUESTED:
                this.status = "requested";
                break;
            default:
                this.status = "ERROR";
        }
    }

    public BorrowStatus(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public static final int BORROWED = 1;
    public static final int RETURNED = 2;
    public static final int OVERDUE = 3;
    public static final int EXTENDED = 4;
    public static final int REQUESTED = 5;

}
