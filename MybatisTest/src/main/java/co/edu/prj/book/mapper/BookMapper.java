package co.edu.prj.book.mapper;

import java.util.List;

import co.edu.prj.book.vo.BookVO;

public interface BookMapper {
	List<BookVO> bookSelectList(); //book 전체리스트 가져오기 (getBookList로도 많이 만듦)(R)
	BookVO bookSelect(BookVO vo);  //한권의 책 상세내역 가져오기(getBook) (R)
	int bookInsert(BookVO vo);     //도서입력(setBook)(C)
	int bookDelete(BookVO vo);     //도서삭제(deleteBook)(D)
	int bookUpdate(BookVO vo);     //도서변경(updateBook)(U)
}
