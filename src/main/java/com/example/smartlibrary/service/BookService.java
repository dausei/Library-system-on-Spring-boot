package com.example.smartlibrary.service;

import com.example.smartlibrary.model.Book;
import com.example.smartlibrary.model.User;
import com.example.smartlibrary.repository.BookRepository;
import com.example.smartlibrary.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public Book addBook(Book b) {
        if (b.getTitle() == null || b.getTitle().isBlank()) {
            throw new IllegalArgumentException("title is required");
        }
        if (b.getBorrowerId() != null) b.setBorrowerId(null);
        b.setAvailable(true);
        return bookRepository.save(b);
    }

    public List<Book> listBooks() {
        return bookRepository.listBooks();
    }


    public Book borrowBook(Long bookId, Long userId) {
        Book book = bookRepository.findById(bookId);
        if (book == null) {
            throw new IllegalArgumentException("book not found: " + bookId);
        }
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("user not found: " + userId);
        }
        if (!book.isAvailable()) {
            throw new IllegalStateException("book is not available");
        }
        book.setAvailable(false);
        book.setBorrowerId(user.getId());
        return bookRepository.save(book);
    }
}
