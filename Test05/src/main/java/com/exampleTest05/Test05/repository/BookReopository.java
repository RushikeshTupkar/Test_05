package com.exampleTest05.Test05.repository;

import com.exampleTest05.Test05.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReopository extends JpaRepository<Book,String> {
}
