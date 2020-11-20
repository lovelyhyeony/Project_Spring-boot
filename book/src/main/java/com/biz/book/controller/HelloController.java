package com.biz.book.controller;

import com.biz.book.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Qualifier("bookServiceV1")
    private final BookService bookService;

    public HelloController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "Hello Spring-boot Web Application Server :)";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("username", "으냉");
        model.addAttribute("tel", "010-1111");
        return "home";
    }

    @RequestMapping(value = "/car")
    public String car(Model model) {
        String[] car = new String[]{"소나타", "그랜저", "페라리", "람보르기니"};
        model.addAttribute("CAR", car);
        return "list_ex";
    }

}
