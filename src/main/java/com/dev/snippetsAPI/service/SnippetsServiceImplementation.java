package com.dev.snippetsAPI.service;

import com.dev.snippetsAPI.model.Snippet;
//import com.dev.snippetsAPI.repository.SnippetRepository;
import com.dev.snippetsAPI.repository.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class SnippetsServiceImplementation implements SnippetsService {


    @Autowired
    private SnippetRepository snippetRepository;


    @Override
    public List<Snippet> getAllSnippets(String category) {
        return snippetRepository.findByCategory(category);
    }

    @Override
    public Snippet addSnippet(Snippet snippet) {
        return snippetRepository.save(snippet);
    }

    @Override
    public String deleteSnippet(String name) {
        Optional<Snippet> snippet = snippetRepository.findByName(name);
        if(snippet.isPresent()){
            snippetRepository.delete(snippet.get());
        }
        else throw new RuntimeException("Snippet not found");
        return "Snippet Deleted";
    }

    @Override
    public Snippet updateSnippet(String name, Snippet snippet) {
        Snippet s = snippetRepository.findByName(name).get();
        s.setCategory(snippet.getCategory());
        s.setName(snippet.getName());
        s.setDescription(snippet.getDescription());
        s.setCode(snippet.getCode());
        snippetRepository.save(s);
        return snippet;
    }

    @Override
    public Optional<Snippet> getOneSnippet(String name) {
        return snippetRepository.findByName(name);
    }
}
