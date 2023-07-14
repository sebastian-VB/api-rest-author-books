package com.sebdev.apirestauthorbooksrelations.Controllers;

import com.sebdev.apirestauthorbooksrelations.Entities.Book;
import com.sebdev.apirestauthorbooksrelations.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<Object> getListBooks(){
        return bookService.listBooks();
    }

    @GetMapping("/{nameBook}")
    public ResponseEntity<Object> getBook(@PathVariable String nameBook){
        return bookService.getBook(nameBook);
    }

    @PostMapping
    public ResponseEntity<Object> saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable Integer id){
        return bookService.deleteBook(id);
    }

}
