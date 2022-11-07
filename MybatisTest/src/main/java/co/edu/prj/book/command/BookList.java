package co.edu.prj.book.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.prj.book.service.BookService;
import co.edu.prj.book.service.impl.BookServiceImpl;
import co.edu.prj.book.vo.BookVO;
import co.edu.prj.common.Command;

public class BookList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 책 목록 가져오기
		BookService dao = new BookServiceImpl();
		List<BookVO> books = new ArrayList<>();
		books = dao.bookSelectList(); //전체목록
		request.setAttribute("books", books); //결과를 books라는 변수로 담음
		return "book/bookList";
	}

}
