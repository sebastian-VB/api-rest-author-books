package com.sebdev.apirestauthorbooksrelations.Controllers;

import com.sebdev.apirestauthorbooksrelations.Entities.Author;
import com.sebdev.apirestauthorbooksrelations.Services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<Object> listAuthors(){
        return authorService.listAuthors();
    }

    @GetMapping("/name-author/{nameAuthor}")
    public ResponseEntity<Object> getAuthorName(@Valid @PathVariable String nameAuthor){
        return authorService.getAuthorByNameAndArtisticName(nameAuthor);
    }

    @GetMapping("/artistic-name-author/{artisticName}")
    public ResponseEntity<Object> getAuthorArtisticName(@PathVariable String artisticName){
        return authorService.getAuthorByNameAndArtisticName(artisticName);
    }

    @PostMapping
    public ResponseEntity<Object> saveAuthor(@Valid @RequestBody Author author){
        return authorService.saveAuthor(author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAuthor(@PathVariable Integer id){
        return authorService.deleteAuthor(id);
    }
}
