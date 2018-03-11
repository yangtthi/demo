package com.example.demo.dao;

import com.example.demo.entity.test.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by yangtthi on 18/3/11.
 */

public interface BookDao extends JpaRepository<Book, Long> {

    List<Book> findAll();

}