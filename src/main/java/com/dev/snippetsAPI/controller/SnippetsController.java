package com.dev.snippetsAPI.controller;


import com.dev.snippetsAPI.model.Snippet;
import com.dev.snippetsAPI.service.SnippetsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SnippetsController {

    @Autowired
    private SnippetsServiceImplementation snippetService;


    @GetMapping("/categories/{category}")
    public ResponseEntity<List<Snippet>> getAllSnippets(@PathVariable String category){
        return new ResponseEntity<List<Snippet>>(snippetService.getAllSnippets(category),HttpStatus.OK);
    }
    @GetMapping("/categories/filter/{name}")
    public ResponseEntity<Optional<Snippet>> getOneSnippet(@PathVariable String name){
       return new ResponseEntity<Optional<Snippet>>(snippetService.getOneSnippet(name),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Snippet> addSnippet(@Validated @RequestBody Snippet snippet){
        return new ResponseEntity<Snippet>(snippetService.addSnippet(snippet),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteSnippet(@RequestParam String name){
        return new ResponseEntity<String>(snippetService.deleteSnippet(name),HttpStatus.NO_CONTENT);
    }
    @PutMapping("/update/{name}")
    public ResponseEntity<Snippet> updateSnippet(@PathVariable String name, @RequestBody Snippet snippet){
        return new ResponseEntity<Snippet>(snippetService.updateSnippet(name,snippet),HttpStatus.OK);
    }


}
