package com.sc.bookservice.infrastructure.rest;

import com.sc.bookservice.domain.AllEvaluations;
import com.sc.bookservice.domain.Evaluation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

public class AllEvaluationsOnARemoteService implements AllEvaluations {

    private String url;

    public AllEvaluationsOnARemoteService(String url) {
        this.url = url;
    }

    @Override
    public List<Evaluation> forBookWithIsbn(String isbn) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<Evaluation[]> response = template.getForEntity(url + isbn, Evaluation[].class);
        return asList(response.getBody());
    }
}