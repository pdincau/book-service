package com.sc.bookservice.domain;

import java.util.List;

public class BookDetailFactory {
    public static BookDetail from(Book book, List<Evaluation> evaluations) {
        return new BookDetail(book.getIsbn(), book.getTitle(), evaluations);
    }
}