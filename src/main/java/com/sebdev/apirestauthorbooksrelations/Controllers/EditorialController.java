package com.sebdev.apirestauthorbooksrelations.Controllers;

import com.sebdev.apirestauthorbooksrelations.Entities.Book;
import com.sebdev.apirestauthorbooksrelations.Entities.Editorial;
import com.sebdev.apirestauthorbooksrelations.Services.EditorialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/editorial")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    @GetMapping
    public ResponseEntity<Object> getListEditorials(){
        return editorialService.listEditorials();
    }

    @GetMapping("/{nameEditorial}")
    public ResponseEntity<Object> getEditorial(@PathVariable String nameEditorial){
        return editorialService.getEditorialByName(nameEditorial);
    }

    @PostMapping
    public ResponseEntity<Object> saveEditorial(@Valid @RequestBody Editorial editorial){
        return editorialService.saveEditorial(editorial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEditorial(@PathVariable Integer id, @RequestBody Editorial editorial){
        return editorialService.updateEditorial(editorial, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEditorial(@PathVariable Integer id){
        return editorialService.deleteEditorial(id);
    }

}
