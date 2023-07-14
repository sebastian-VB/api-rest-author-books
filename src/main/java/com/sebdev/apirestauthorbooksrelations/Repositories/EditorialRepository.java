package com.sebdev.apirestauthorbooksrelations.Repositories;

import com.sebdev.apirestauthorbooksrelations.Entities.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EditorialRepository extends JpaRepository<Editorial, Integer> {

    Optional<Editorial> findByNameEditorial(String nameEditorial);
}
