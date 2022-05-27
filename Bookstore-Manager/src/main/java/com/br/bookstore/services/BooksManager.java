package com.br.bookstore.services;

import com.br.bookstore.domain.Book;

import java.util.List;

public interface BooksManager {
    void addBooks(Book... books);
    Book removeBook(Book book);
    void changeBookPrice(Book book, float newPrice);
    List<Book> getBooks();
    int getBookIndex(Book book);
}
