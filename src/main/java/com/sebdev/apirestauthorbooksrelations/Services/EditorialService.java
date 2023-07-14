package com.sebdev.apirestauthorbooksrelations.Services;

import com.sebdev.apirestauthorbooksrelations.Entities.Editorial;
import com.sebdev.apirestauthorbooksrelations.Repositories.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    HashMap<String, Object> information_requested;

    public ResponseEntity<Object> listEditorials(){

        information_requested = new LinkedHashMap<>();
        List<Editorial> editorials = editorialRepository.findAll();

        if(editorials.isEmpty()){
            information_requested.put("error", true);
            information_requested.put("message", "No hay editoriales registradas");
            return new ResponseEntity<>(information_requested, HttpStatus.NOT_FOUND);
        }

        information_requested.put("error", false);
        information_requested.put("data", editorials);
        return new ResponseEntity<>(information_requested, HttpStatus.OK);
    }

    public ResponseEntity<Object> getEditorialByName(String nameEditorial){

        information_requested = new LinkedHashMap<>();
        Optional<Editorial> editorialOptional = editorialRepository.findByNameEditorial(nameEditorial);

        if(!editorialOptional.isPresent()){
            information_requested.put("error", true);
            information_requested.put("message", "No se encuentra la editorial");
            return new ResponseEntity<>(information_requested, HttpStatus.NOT_FOUND);
        }

        information_requested.put("error", false);
        information_requested.put("data", editorialOptional.get());
        return new ResponseEntity<>(information_requested, HttpStatus.OK);
    }

    public ResponseEntity<Object> saveEditorial(Editorial editorial){

        information_requested = new LinkedHashMap<>();
        String location;

        information_requested.put("error", true);
        information_requested.put("message", "Editorial registrada con éxito");

        location = editorial.getStreet() + " - " + editorial.getCity();
        editorial.setLocation(location);
        editorialRepository.save(editorial);

        return new ResponseEntity<>(information_requested, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> updateEditorial(Editorial editorial, Integer id){

        information_requested = new LinkedHashMap<>();
        String location;
        Optional<Editorial> editorialOptional = editorialRepository.findById(id);

        if(!editorialOptional.isPresent()){
            information_requested.put("error", true);
            information_requested.put("message", "No se encuentra la editorial");
            return new ResponseEntity<>(information_requested, HttpStatus.NOT_FOUND);
        }

        location = editorial.getStreet() + " - " + editorial.getCity();
        editorial.setLocation(location);
        editorial.setId(editorialOptional.get().getId());
        editorialRepository.save(editorial);

        return new ResponseEntity<>(information_requested, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> deleteEditorial(Integer id){

        information_requested = new LinkedHashMap<>();
        Optional<Editorial> editorialOptional = editorialRepository.findById(id);

        if(!editorialOptional.isPresent()){
            information_requested.put("error", true);
            information_requested.put("message", "No se encuentra la editorial");
            return new ResponseEntity<>(information_requested, HttpStatus.NOT_FOUND);
        }

        information_requested.put("error", false);
        information_requested.put("message", "Editorial eliminada con exito");
        editorialRepository.delete(editorialOptional.get());
        return new ResponseEntity<>(information_requested, HttpStatus.OK);
    }
}
