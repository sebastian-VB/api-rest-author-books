package com.sebdev.apirestauthorbooksrelations.Repositories;

import com.sebdev.apirestauthorbooksrelations.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findByNameBook(String nameBook);
}
