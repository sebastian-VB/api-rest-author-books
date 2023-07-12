package com.sebdev.apirestauthorbooksrelations.Repositories;

import com.sebdev.apirestauthorbooksrelations.Entities.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorialRepository extends JpaRepository<Editorial, Integer> {

    Editorial findByNameEditorial(String nameEditorial);
}
