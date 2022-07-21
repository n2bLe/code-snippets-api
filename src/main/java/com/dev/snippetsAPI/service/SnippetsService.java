package com.dev.snippetsAPI.service;

import com.dev.snippetsAPI.model.Snippet;

import java.util.List;
import java.util.Optional;

public interface SnippetsService {
    List<Snippet> getAllSnippets();
    List<Snippet> getSnippets(String category);
    Snippet addSnippet(Snippet snippet);
    String deleteSnippet(String name);
    Snippet updateSnippet(String name, Snippet snippet);
    Optional<Snippet> getOneSnippet(String name);
}
