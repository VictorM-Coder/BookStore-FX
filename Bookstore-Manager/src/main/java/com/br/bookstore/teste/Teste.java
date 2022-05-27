package com.br.bookstore.teste;

import com.br.bookstore.domain.Book;
import com.br.bookstore.domain.Genre;
import com.br.bookstore.domain.managers.Bookstore;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Teste {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Bookstore bookstore = createBooks();
        Bookstore bookstore = new Bookstore();
        Book book = new Book("call of cthulhu", "HP Lovecraft", "HP", Genre.HORROR, 50, 23.4F, LocalDate.now());
        Book book1 = new Book("Senhor dos anéis", "Tolkien", "SR", Genre.FANTASY, 300, 59.99F, LocalDate.now());
        Book book2 = new Book("HunterXHunter", "Togashi", "Jump", Genre.ADVENTURE, 50, 20F, LocalDate.now());
        Book book3 = new Book("Berserk", "Miura", "Seinen Jump", Genre.FANTASY, 50, 25F, LocalDate.now());
        Book book4 = new Book("Vih tube - Autobiografia", "Vitória Youtube", "Youtube books", Genre.HORROR, 500, 199.99F, LocalDate.now());
        bookstore.addBooks(book, book1, book2, book3, book4);
        System.out.println(bookstore.toString());

        bookstore.changeBookPrice(book, 10F);
        bookstore.removeBook(book4);
        System.out.println(bookstore.getBooks());

    }

    private static Bookstore createBooks(){
        int size = scanner.nextInt();
        Bookstore bookstore = new Bookstore();

        for (int cont  =0; cont < size; cont++){
            scanner.nextLine();
            System.out.print("name: ");
            String name = scanner.nextLine();

            System.out.print("writer: ");
            String writer = scanner.nextLine();

            System.out.print("publisher: ");
            String publisher = scanner.nextLine();

            System.out.print("genre: ");
            String genre = scanner.nextLine();

            System.out.print("pages: ");
            int pages = scanner.nextInt();

            System.out.print("price: ");
            float price = scanner.nextFloat();

            Book book = new Book(name, writer, publisher, Genre.valueOf(genre), pages, price, LocalDate.now());
            bookstore.addBooks(book);
        }
        return bookstore;
    }
}
