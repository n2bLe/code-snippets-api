package com.dev.snippetsAPI.repository;

import com.dev.snippetsAPI.model.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SnippetRepository extends JpaRepository<Snippet,Long> {
    List<Snippet> findByCategory(String category);
    Optional<Snippet> findByName(String name);
}
