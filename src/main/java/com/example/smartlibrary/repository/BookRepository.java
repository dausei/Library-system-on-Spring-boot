package com.example.smartlibrary.repository;

import com.example.smartlibrary.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {
    private long nextId = 1;
    private Map<Long, Book> books = new HashMap<>();

    public Book save(Book b){
        if (b.getId() == 0) {
            b.setId(nextId);
            nextId++;
        }
        books.put(b.getId(), b);
        return b;
    }

    public Book findById(long id){
        return books.get(id);
    }

    public List<Book> listBooks(){
        return new ArrayList<>(books.values());
    }
}