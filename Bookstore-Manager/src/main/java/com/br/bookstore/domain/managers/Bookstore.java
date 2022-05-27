package com.br.bookstore.domain.managers;

import com.br.bookstore.domain.Book;
import com.br.bookstore.services.BooksManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bookstore implements BooksManager {
    private List<Book> books;

    public Bookstore(){
        this.books = new ArrayList<>(20);
    }

    public Bookstore(List<Book> books){
        this.books =  books;
    }

    @Override
    public void addBooks(Book... books) {
        this.books.addAll(Arrays.asList(books));
    }

    @Override
    public Book removeBook(Book book) {
        int indexRemoved = this.books.indexOf(book);

        if (indexRemoved > -1){
            this.books.remove(book);
        }

        return null;
    }

    @Override
    public void changeBookPrice(Book book, float newPrice){
        if(this.books.contains(book)){
            book.setPrice(newPrice);
        }
    }

    @Override
    public List<Book> getBooks() {
        return this.books;
    }

    @Override
    public int getBookIndex(Book book) {
        return this.books.indexOf(book);
    }
}
