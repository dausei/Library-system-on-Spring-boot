package com.example.smartlibrary.controller;

import com.example.smartlibrary.model.Book;
import com.example.smartlibrary.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> listBooks(){
        return bookService.listBooks();
    }

    @PostMapping("/{id}/borrow")
    public Book borrowBook(@PathVariable("id") Long bookId,
                           @RequestBody BorrowRequest req) {
        return bookService.borrowBook(bookId, req.getUserId());
    }
}