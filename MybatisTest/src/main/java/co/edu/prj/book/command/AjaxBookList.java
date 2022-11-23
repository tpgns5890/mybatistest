package co.edu.prj.book.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.prj.book.service.BookService;
import co.edu.prj.book.service.impl.BookServiceImpl;
import co.edu.prj.book.vo.BookVO;
import co.edu.prj.common.Command;

public class AjaxBookList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//json 타입 데이터 필요.
		BookService dao = new BookServiceImpl();
		List<BookVO> books = new ArrayList<>();
		books = dao.bookSelectList();
		
		ObjectMapper mapper = new ObjectMapper();
		return null;
	}

}
