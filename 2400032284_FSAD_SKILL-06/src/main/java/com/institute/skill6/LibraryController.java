package com.institute.skill6;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class LibraryController {

    List<Book> books = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library";
    }

    @GetMapping("/count")
    public int count() {
        return 100;
    }

    @GetMapping("/price")
    public double price() {
        return 499.99;
    }

    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList("Spring Boot", "Java Programming", "Microservices");
    }

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable("id") int id) {
        return "Book details for ID: " + id;
    }

    @GetMapping("/search")
    public String search(@RequestParam("title") String title) {
        return "Searching for book: " + title;
    }

    @GetMapping("/author/{name}")
    public String author(@PathVariable("name") String name) {
        return "Books written by " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        books.add(book);
        return "Book added successfully";
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return books;
    }
}