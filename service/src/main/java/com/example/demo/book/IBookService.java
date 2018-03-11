package com.example.demo.book;

import com.example.demo.entity.test.Book;

import java.util.List;
import java.util.Optional;

/**
 * Created by yangtthi on 18/3/11.
 */

public interface IBookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

}
