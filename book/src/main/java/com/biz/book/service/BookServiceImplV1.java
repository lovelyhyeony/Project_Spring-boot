package com.biz.book.service;

import com.biz.book.domain.BookVO;
import com.biz.book.persistence.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service("bookServiceV1")
public class BookServiceImplV1 implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImplV1(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookVO> selectAll() {
        List<BookVO> bookVOList = bookRepository.findAll();
        return bookVOList;
    }

    /**
     * Optional
     * 데이터가 없음을 null이 아닌 어떤 명확한 근거를
     * 바탕으로 알고 싶다 라는 취지에서 새로 생성한 Wrapper class
     * VO클래스를 감싸는 Wrapper 클래스
     * <p>
     * 일반적으로 DB핸들링에서 findById(Long id)를 수행한 후
     * id에 해당하는 데이터가 없을 경우 return 값이 null이었다.
     * if(vo == null) {
     * log.debug("데이터가 없음")
     * }
     * <p>
     * Optional 은 어떤 객체의 저장된 값이 null 인가를 비교하는 것을
     * 사용하지 않기 위해서 새롭게 등장한 class 이다.
     * <p>
     * null 값을 비교하는 것 보다 연산비용이 많이 든다.
     * 아직은 논란의 여지가 많다.
     */
    @Override
    public BookVO findById(Long id) {
        Optional<BookVO> bookVO = bookRepository.findById(id);

        // 만약 findById() 수행하여 데이터가 없으면
        // 새로운 VO를 만들고 id값을 -1로 세팅하여 리턴하라
        return bookVO.orElse(BookVO.builder().id(-1L).build()); // 실질적으로 권장
        // return bookVO.get(); << wrap만 벗기고 get하는 코드 (비용이 많이든다)
    }

    @Override
    public int insert(BookVO bookVO) {
        bookRepository.save(bookVO);
        return 0;
    }

    @Override
    public int update(BookVO bookVO) {
        bookRepository.save(bookVO);
        return 0;
    }

    @Override
    public int delete(Long id) {
        bookRepository.deleteById(id);
        return 0;
    }

    @Override
    public Page<BookVO> pageSelect(Pageable pageable) {
        // pagination의 페이지 번호를 클릭했을 때 데이터를 가져오기 쉽도록 index 값을 변화
        // getPageNumber 값을 0부터 시작하도록
        int page = pageable.getPageNumber() == 0 ? 0 : pageable.getPageNumber() - 1;
        // 몇 페이지의 데이터를 몇개 가져올거냐
        pageable = PageRequest.of(page,10); // 한페이지의 열개만 보여주라(내가 클릭한 페이지에서 열개)

        log.debug(pageable.toString());

        return bookRepository.findAll(pageable); // 다오한테 말해서 db에서 데이터 10개만 뽑은 다음에 컨트롤러에 넘어감
    }
}
