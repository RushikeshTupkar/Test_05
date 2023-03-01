package com.exampleTest05.Test05.service;

import com.exampleTest05.Test05.model.Book;
import com.exampleTest05.Test05.model.Student;
import com.exampleTest05.Test05.repository.BookReopository;
import com.exampleTest05.Test05.repository.StudentRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private BookReopository bookReopository;
    public Book addBook(JSONObject jsonObject) {
        Book book = new Book();
        String book_id = UUID.randomUUID().toString();
        book.setBook_id(book_id);
        book.setTitle(jsonObject.getString("title"));
        book.setAuthor(jsonObject.getString("author"));
        book.setDescreiption(jsonObject.getString("descreiption"));
        book.setPrice(jsonObject.getString("price"));
        Student student = studentRepository.findById(jsonObject.getString("student_id")).get();
        book.setStudent(student);
        return bookReopository.save(book);
    }

    public List<Book> getALlBooks(String book_id) {
        if(book_id!=null){
            List<Book>list = new ArrayList<>();
            list.add(bookReopository.findById(book_id).get());
            return list;
        }return bookReopository.findAll();
    }

    public void deleteBook(String bookId) {
        bookReopository.deleteById(bookId);
    }
}
