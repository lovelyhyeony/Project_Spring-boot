package com.biz.book.controller;

import com.biz.book.domain.BookVO;
import com.biz.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.print.Book;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Qualifier("bookServiceV1")
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    // 서비스한테 pageable 토스! 서비스에서 적당히 요리를 한 후 pageRequest 한테 보내고
    // pageable에 담고 다시 다오의 findall에 보냄 나머지는 알아서
    public String getList(@PageableDefault Pageable pageable, Model model) {
        Page<BookVO> bookVOList = bookService.pageSelect(pageable);
        model.addAttribute("BOOKS", bookVOList);
        return "book/list";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(String id, Model model) {
        BookVO bookVO = bookService.findById(Long.valueOf(id));
        model.addAttribute("BOOK", bookVO);
        return "book/view";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        bookService.delete(Long.valueOf(id));
        return "redirect:/book/list";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(@ModelAttribute BookVO bookVO, Model model) {
        model.addAttribute("BOOK", bookVO);
        return "book/input";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@ModelAttribute BookVO bookVO) {
        log.debug(bookVO.toString());
        bookService.insert(bookVO);
        return "redirect:/book/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") String id, Model model) {
        BookVO bookVO = bookService.findById(Long.valueOf(id));
        model.addAttribute("BOOK", bookVO);
        return "book/input";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute BookVO bookVO, Model model) {
        bookService.update(bookVO);
        model.addAttribute("id", bookVO.getId());
        return "redirect:/book/view/" + bookVO.getId();
    }
}
