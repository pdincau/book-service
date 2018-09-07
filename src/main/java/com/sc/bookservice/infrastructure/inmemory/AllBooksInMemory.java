package com.sc.bookservice.infrastructure.inmemory;

import com.sc.bookservice.domain.Book;
import com.sc.bookservice.domain.AllBooks;

import java.util.List;

import static java.util.Arrays.asList;

public class AllBooksInMemory implements AllBooks {
    
    @Override
    public List<Book> get() {
        Book aBook = new Book("The catcher in the rye", "12345");
        Book anotherBook = new Book("The Silmarillion", "98765");

        return asList(aBook, anotherBook);
    }
}
