package com.sc.bookservice.infrastructure.rest;

import com.sc.bookservice.domain.Evaluation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(name = "book-evaluation", fallback = EvaluationsClient.EvaluationsClientWithFallback.class)
public interface EvaluationsClient {

    @RequestMapping(method = GET, value = "/evaluations/{isbn}", consumes = "application/json")
    List<Evaluation> evaluationsFor(@PathVariable("isbn") String isbn);

    @SuppressWarnings("unused")
    @Component
    class EvaluationsClientWithFallback implements EvaluationsClient {

        @Override
        public List<Evaluation> evaluationsFor(String isbn) {
            return emptyList();
        }
    }
}
