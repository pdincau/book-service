package com.sc.bookservice.infrastructure.rest;

import com.sc.bookservice.domain.AllEvaluations;
import com.sc.bookservice.domain.Evaluation;

import java.util.List;

public class AllEvaluationsOnARemoteService implements AllEvaluations {

    private EvaluationsClient client;

    public AllEvaluationsOnARemoteService(EvaluationsClient client) {
        this.client = client;
    }

    @Override
    public List<Evaluation> forBookWithIsbn(String isbn) {
        return client.evaluationsFor(isbn);
    }
}