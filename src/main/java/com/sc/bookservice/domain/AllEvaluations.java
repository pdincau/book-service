package com.sc.bookservice.domain;

import java.util.List;

public interface AllEvaluations {

    List<Evaluation> forBookWithIsbn(String isbn);
}
