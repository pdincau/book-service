package com.sc.bookservice.domain;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class BookDetailService {
    private final AllBooks allBooks;
    private final AllEvaluations allEvaluations;

    public BookDetailService(AllBooks allBooks, AllEvaluations allEvaluations) {
        this.allBooks = allBooks;
        this.allEvaluations = allEvaluations;
    }

    public List<BookDetail> allDetails() {
        List<Book> books = allBooks.get();
        return books
                .stream()
                .map(mapToBookDetail())
                .collect(toList());
    }

    private Function<Book, BookDetail> mapToBookDetail() {
        return book -> BookDetailFactory.from(book, allEvaluations.forBookWithIsbn(book.getIsbn()));
    }

}