package com.example.demo.controller.mysql;

import com.example.demo.book.IBookService;
import com.example.demo.common.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangtthi on 18/3/11.
 */
@RestController
public class BookController {

    @Autowired
    private IBookService bookService;

    @RequestMapping(value = "/book/list", method = RequestMethod.GET)
    public String bookList(){
        return ResponseUtil.success(bookService.findAll());
    }
}
