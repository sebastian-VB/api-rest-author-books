package com.sebdev.apirestauthorbooksrelations.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_editorial")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editorial_id")
    private int id;
    @NotNull
    private String nameEditorial;
    @NotNull
    private String street;
    @NotNull
    private String city;
    private String location;

    @JsonManagedReference
    @OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    public Editorial(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameEditorial() {
        return nameEditorial;
    }

    public void setNameEditorial(String nameEditorial) {
        this.nameEditorial = nameEditorial;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
