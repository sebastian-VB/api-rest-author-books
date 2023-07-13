package com.sebdev.apirestauthorbooksrelations.Services;

import com.sebdev.apirestauthorbooksrelations.Entities.Author;
import com.sebdev.apirestauthorbooksrelations.Repositories.AuthorRepository;
import com.sebdev.apirestauthorbooksrelations.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    HashMap<String, Object> information_returned;

    public ResponseEntity<Object> listAuthors (){

        information_returned = new LinkedHashMap<>();
        List<Author> authors = authorRepository.findAll();

        if(authors.isEmpty()){
            information_returned.put("error", true);
            information_returned.put("message", "No se encuentran autores");
            return new ResponseEntity<>(information_returned, HttpStatus.NOT_FOUND);
        }

        information_returned.put("error", false);
        information_returned.put("data", authors);
        return new ResponseEntity<>(information_returned, HttpStatus.OK);

    }

    public ResponseEntity<Object> getAuthorByNameAndArtisticName(String nameAuthor){

        information_returned = new LinkedHashMap<>();
        Optional<Author> author = authorRepository.findByNameAuthor(nameAuthor);
        Optional<Author> author2 = authorRepository.findAuthorByArtisticName(nameAuthor);

        if(!author.isPresent() && !author2.isPresent()){
            information_returned.put("error", true);
            information_returned.put("message", "No se encuentran el autor buscado");
            return new ResponseEntity<>(information_returned, HttpStatus.NOT_FOUND);
        }
        else{
            if(author.isPresent() && !author2.isPresent()){
                information_returned.put("data", author);
            }
            if(author2.isPresent() && !author.isPresent()){
                information_returned.put("data", author2);
            }
            if(author.isPresent() && author2.isPresent()){
                information_returned.put("data", author2);
            }
            information_returned.put("error", false);
            return new ResponseEntity<>(information_returned, HttpStatus.OK);
        }

    }

    public ResponseEntity<Object> saveAuthor(Author author){

        information_returned = new LinkedHashMap<>();

        information_returned.put("error", false);
        information_returned.put("message", "Autor guardado con éxito");
        authorRepository.save(author);

        return  new ResponseEntity<>(information_returned, HttpStatus.CREATED);
    }

    //queda pendiente el update

    public ResponseEntity<Object> deleteAuthor(int id){

        information_returned = new LinkedHashMap<>();
        Optional<Author> authorDelete = authorRepository.findById(id);

        if(!authorDelete.isPresent()){
            information_returned.put("error", true);
            information_returned.put("message", "No se encuentran el autor buscado");
            return new ResponseEntity<>(information_returned, HttpStatus.NOT_FOUND);
        }

        authorRepository.delete(authorDelete.get());
        information_returned.put("error", false);
        information_returned.put("message", "Autor eliminado con éxito");

        return  new ResponseEntity<>(information_returned, HttpStatus.ACCEPTED);
    }

}
