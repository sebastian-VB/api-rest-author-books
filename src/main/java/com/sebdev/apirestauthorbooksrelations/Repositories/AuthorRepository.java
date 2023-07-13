package com.sebdev.apirestauthorbooksrelations.Repositories;

import com.sebdev.apirestauthorbooksrelations.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Optional<Author> findByNameAuthor(String nameAuthor);

    Optional<Author> findAuthorByArtisticName(String artisticName);
}
