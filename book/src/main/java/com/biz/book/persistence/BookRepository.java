package com.biz.book.persistence;

import com.biz.book.domain.BookVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookVO, Long> {

}
