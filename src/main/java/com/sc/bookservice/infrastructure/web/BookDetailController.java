package com.sc.bookservice.infrastructure.web;

import com.sc.bookservice.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
public class BookDetailController {

    private BookDetailService detailService;

    @Inject
    public BookDetailController(BookDetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("/books")
    List<BookDetail> all() {
       List<BookDetail> allBookDetails = detailService.allDetails();
        return allBookDetails;
    }

}
