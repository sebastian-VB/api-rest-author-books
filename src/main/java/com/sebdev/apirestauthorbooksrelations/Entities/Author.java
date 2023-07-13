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
    @NotNull
    private String nameAuthor;
    private String artisticName;

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

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getArtisticName() {
        return artisticName;
    }

    public void setArtisticName(String artisticName) {
        this.artisticName = artisticName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
