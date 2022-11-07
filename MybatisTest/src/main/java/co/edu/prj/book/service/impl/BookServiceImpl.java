package co.edu.prj.book.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.edu.prj.book.mapper.BookMapper;
import co.edu.prj.book.service.BookService;
import co.edu.prj.book.vo.BookVO;
import co.edu.prj.common.DataSource;

public class BookServiceImpl implements BookService {
	//dao 연결, data source객체 연결, mapper연결
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private BookMapper map = sqlSession.getMapper(BookMapper.class);
	
	@Override
	public List<BookVO> bookSelectList() {
		// book 전체리스트
		return map.bookSelectList();
	}

	@Override
	public BookVO bookSelect(BookVO vo) {
		// 한권의 책 정보 가져오기
		return map.bookSelect(vo);
	}

	@Override
	public int bookInsert(BookVO vo) {
		// 책을 입력하는 곳
		return map.bookInsert(vo);
	}

	@Override
	public int bookDelete(BookVO vo) {
		// 책을 삭제하는 곳
		return map.bookDelete(vo);
	}

	@Override
	public int bookUpdate(BookVO vo) {
		// 책 내용 변경
		return map.bookUpdate(vo);
	}
}
