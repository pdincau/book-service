package com.sc.bookservice.domain;

import java.util.List;

public class BookDetail {
    private final String isbn;
    private final String title;
    private final List<Evaluation> evaluations;

    public BookDetail(String isbn, String title, List<Evaluation> evaluations) {
        this.isbn = isbn;
        this.title = title;
        this.evaluations = evaluations;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }
}
