package com.sebdev.apirestauthorbooksrelations.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;
    @NotNull
    private String name;
    private int number_vol;
    @NotNull
    private LocalDate publication_date;
    private int antiquity;

}
