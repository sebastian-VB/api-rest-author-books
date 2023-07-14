package com.sebdev.apirestauthorbooksrelations.Services;

import com.sebdev.apirestauthorbooksrelations.Entities.Book;
import com.sebdev.apirestauthorbooksrelations.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    HashMap<String, Object> information_returned;

    public ResponseEntity<Object> listBooks(){

        information_returned = new LinkedHashMap<>();
        List<Book> books = bookRepository.findAll();

        if(books.isEmpty()){
            information_returned.put("error", true);
            information_returned.put("message", "No hay libros registrados");
            return new ResponseEntity<>(information_returned, HttpStatus.NOT_FOUND);
        }

        information_returned.put("error", false);
        information_returned.put("data", books);
        return new ResponseEntity<>(information_returned, HttpStatus.OK);

    }

    public ResponseEntity<Object> getBook(String nameBook){

        information_returned = new LinkedHashMap<>();
        Optional<Book> bookOptional = bookRepository.findByNameBook(nameBook);

        if(!bookOptional.isPresent()){
            information_returned.put("error", true);
            information_returned.put("message", "No se ha encontrado el libro");
            return new ResponseEntity<>(information_returned, HttpStatus.NOT_FOUND);
        }

        information_returned.put("error", false);
        information_returned.put("data", bookOptional);
        return new ResponseEntity<>(information_returned, HttpStatus.OK);
    }

    public ResponseEntity<Object> saveBook(Book book){

        information_returned = new LinkedHashMap<>();
        information_returned.put("error", false);
        information_returned.put("message", "Libro se guardó con exito");

        book.setAntiquity(Period.between(book.getPublication_date(), LocalDate.now()).getYears());
        bookRepository.save(book);

        return new ResponseEntity<>(information_returned, HttpStatus.OK);
    }

    //queda pendiente el actualizar

    public ResponseEntity<Object> deleteBook(Integer id){

        information_returned = new LinkedHashMap<>();
        Optional<Book> bookOptional = bookRepository.findById(id);

        if(!bookOptional.isPresent()){
            information_returned.put("error", true);
            information_returned.put("message", "No se ha encontrado el libro");
            return new ResponseEntity<>(information_returned, HttpStatus.NOT_FOUND);
        }

        bookRepository.delete(bookOptional.get());
        information_returned.put("error", false);
        information_returned.put("message", "Libro eliminado con éxito");

        return  new ResponseEntity<>(information_returned, HttpStatus.ACCEPTED);
    }
}
