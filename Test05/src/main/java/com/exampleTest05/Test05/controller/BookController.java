package com.exampleTest05.Test05.controller;

import com.exampleTest05.Test05.model.Book;
import com.exampleTest05.Test05.service.BookService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/add_book")
    public Book addBook(@RequestBody String book){
        JSONObject jsonObject = new JSONObject(book);
        return bookService.addBook(jsonObject);
    }

    @GetMapping("/get_all_books")
    public List<Book> getAllBooks(@Nullable @RequestParam("book_id") String book_id){
        return bookService.getALlBooks(book_id);
    }

    @DeleteMapping("/delete_book_by_id")
    public void deleteBook(@RequestParam("book_id") String book_id){
        bookService.deleteBook(book_id);
    }
}
