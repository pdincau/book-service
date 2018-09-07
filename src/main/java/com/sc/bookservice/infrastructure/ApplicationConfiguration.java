package com.sc.bookservice.infrastructure;

import com.sc.bookservice.domain.AllBooks;
import com.sc.bookservice.domain.AllEvaluations;
import com.sc.bookservice.domain.BookDetailService;
import com.sc.bookservice.infrastructure.inmemory.AllBooksInMemory;
import com.sc.bookservice.infrastructure.rest.AllEvaluationsOnARemoteService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Value("${evaluations.service.id}")
    String evaluationServiceId;

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    AllEvaluations allEvaluations(RestTemplate restTemplate) {
        return new AllEvaluationsOnARemoteService(evaluationServiceId, restTemplate);
    }

    @Bean
    AllBooks allBooks() {
        return new AllBooksInMemory();
    }

    @Bean
    BookDetailService bookDetailService(AllBooks allBooks, AllEvaluations allEvaluations) {
        return new BookDetailService(allBooks, allEvaluations);
    }
}
