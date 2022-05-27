package com.br.bookstore.domain;

import com.br.bookstore.domain.exceptions.InvalidValueException;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private String name;
    private String writer;
    private String publisher;
    private Genre genre;
    private int pages;
    private float price;
    private LocalDate publicationDate;

    public Book(String name, String writer, String publisher, Genre genre, int pages, float price, LocalDate publicationDate) throws InvalidValueException {
        this.setName(name);
        this.setWriter(writer);
        this.setPrice(price);
        this.setPages(pages);
        this.setPublisher(publisher);
        this.setPublicationDate(publicationDate);

        this.genre = genre;
    }

    @Override
    public String toString(){
        return "-" + this.name + "-" +
                "\nwriter: " + this.writer+
                "\npublisher: " + this.publisher+
                "\ngenre: " + this.genre+
                "\ndate: "+ this.publicationDate.toString()+
                "\npages: " + this.pages+
                "\nprice: " + this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Book){
            Book book = (Book) o;
            return (this.pages == book.pages && this.genre == book.genre && this.publisher.equals(book.publisher) && this.writer.equals(book.writer) && this.price == book.price && this.publicationDate.equals(book.publicationDate));
        }
        return false;
    }

    public void setPrice(float price) throws InvalidValueException{
        if (validade(price)) this.price = price;
        else throw new InvalidValueException("Price");
    }

    private Book setPublicationDate(LocalDate publicationDate) throws InvalidValueException{
        this.publicationDate = publicationDate;
        return this;
    }

    private void setName(String name) throws InvalidValueException{
        if (validade(name)) this.name = name;
        else throw new InvalidValueException("Name");
    }

    private void setWriter(String writer) throws InvalidValueException{
        if (validade(writer)) this.writer = writer;
        else throw new InvalidValueException("writer");
    }

    private void setPublisher(String publisher) throws InvalidValueException{
        if (validade(publisher)) this.publisher = publisher;
        else throw new InvalidValueException("publisher");
    }

    private void setPages(int pages) throws InvalidValueException{
        if (validade(pages)) this.pages = pages;
        else throw new InvalidValueException("pages");
    }

    //Validates
    private static boolean validade(String value){
        if (value != null) return value.length() > 0;
        return false;
    }

    private static boolean validade(int value){
        return (value > 0);
    }

    private static boolean validade(float value){
        return (value >= 0);
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPages() {
        return pages;
    }

    public float getPrice() {
        return price;
    }

    public Genre getGenre() {
        return genre;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }
}
