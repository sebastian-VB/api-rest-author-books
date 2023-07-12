package com.sebdev.apirestauthorbooksrelations.Repositories;

import com.sebdev.apirestauthorbooksrelations.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author findByNameAuthor(String nameAuthor);

    Author finByArtisticNameAuthor(String artisticNameAuthor);
}
