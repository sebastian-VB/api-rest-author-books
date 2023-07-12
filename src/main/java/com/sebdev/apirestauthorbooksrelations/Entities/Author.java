package com.sebdev.apirestauthorbooksrelations.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;
    private String name;
    @NotNull
    private String artistic_name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "auths_books",
            joinColumns = @JoinColumn(name = "fk_author_id", referencedColumnName = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_book_id", referencedColumnName = "book_id")
    )
    private Set<Book> books = new HashSet<>();

    public Author(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistic_name() {
        return artistic_name;
    }

    public void setArtistic_name(String artistic_name) {
        this.artistic_name = artistic_name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
