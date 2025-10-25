package com.example.smartlibrary.model;

public class Book {
    private long id;
    private String title;
    private boolean available;
    private long borrowerId;

    public Book(long id, String title, boolean available, long borrowerId) {
        this.id = id;
        this.title = title;
        this.available = available;
        this.borrowerId = borrowerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(long borrowerId) {
        this.borrowerId = borrowerId;
    }
}
