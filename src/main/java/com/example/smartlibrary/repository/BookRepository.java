package com.example.smartlibrary.repository;


import com.example.smartlibrary.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {
    private long nextId = 1;
    private Map<Long, Book> books = new HashMap<>();

    public Book save(Book b){
        b.setId(nextId);
        books.put(b.getId(), b);
        nextId++;
        return b;
    }

    public Book findById(long id){
        return books.get(id);
    }

    public List<Book> listBooks(){
        return new ArrayList<>(books.values());
    }
}
