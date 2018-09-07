package com.sc.bookservice.infrastructure;

import com.sc.bookservice.domain.AllBooks;
import com.sc.bookservice.domain.AllEvaluations;
import com.sc.bookservice.domain.BookDetailService;
import com.sc.bookservice.infrastructure.inmemory.AllBooksInMemory;
import com.sc.bookservice.infrastructure.rest.AllEvaluationsOnARemoteService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Value("${evaluations.url}")
    String evaluationsUrl;

    @Bean
    AllEvaluations allEvaluations() {
        return new AllEvaluationsOnARemoteService(evaluationsUrl);
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
