package com.sc.bookservice.infrastructure.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sc.bookservice.domain.AllEvaluations;
import com.sc.bookservice.domain.Evaluation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class AllEvaluationsOnARemoteService implements AllEvaluations {

    private String evaluationServiceId;
    private RestTemplate template;

    public AllEvaluationsOnARemoteService(String evaluationServiceId, RestTemplate template) {
        this.evaluationServiceId = evaluationServiceId;
        this.template = template;
    }

    @Override
    @HystrixCommand(fallbackMethod = "defaultEvaluations")
    public List<Evaluation> forBookWithIsbn(String isbn) {
        ResponseEntity<Evaluation[]> response = template.getForEntity("http://{evaluationServiceId}/evaluations/{isbn}", Evaluation[].class, evaluationServiceId, isbn);
        return asList(response.getBody());
    }

    @SuppressWarnings("unused")
    List<Evaluation> defaultEvaluations(String isbn) {
        return emptyList();
    }
}