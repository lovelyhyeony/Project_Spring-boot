package com.biz.book.service;

import com.biz.book.domain.BookVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    public List<BookVO> selectAll();

    public BookVO findById(Long id);

    public int insert(BookVO bookVO);

    public int update(BookVO bookVO);

    public int delete(Long id);

    public Page<BookVO> pageSelect(Pageable pageable);
}
