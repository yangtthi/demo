package com.example.demo.book.impl;

import com.example.demo.book.IBookService;
import com.example.demo.entity.test.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by yangtthi on 18/3/11.
 */

@Service
public class BookServiceImpl implements IBookService {

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return null;
    }


//    @Autowired
//    private BookDao bookDao;
//
//    @Override
//    public List<Book> findAll() {
//        return bookDao.findAll();
//    }
//
//    @Override
//    public Optional<Book> findById(Long id) {
//        return bookDao.findById(id);
//    }

}
