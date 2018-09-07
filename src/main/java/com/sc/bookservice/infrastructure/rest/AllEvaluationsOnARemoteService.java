package com.sc.bookservice.infrastructure.rest;

import com.sc.bookservice.domain.AllEvaluations;
import com.sc.bookservice.domain.Evaluation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

public class AllEvaluationsOnARemoteService implements AllEvaluations {

    private String evaluationServiceId;
    private RestTemplate template;

    public AllEvaluationsOnARemoteService(String evaluationServiceId, RestTemplate template) {
        this.evaluationServiceId = evaluationServiceId;
        this.template = template;
    }

    @Override
    public List<Evaluation> forBookWithIsbn(String isbn) {
        ResponseEntity<Evaluation[]> response = template.getForEntity("http://{evaluationServiceId}/evaluations/{isbn}", Evaluation[].class, evaluationServiceId, isbn);
        return asList(response.getBody());
    }
}