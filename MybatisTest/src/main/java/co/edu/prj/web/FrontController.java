package co.edu.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.prj.book.command.AjaxBookList;
import co.edu.prj.book.command.AjaxMainForm;
import co.edu.prj.book.command.BookList;
import co.edu.prj.common.Command;
import co.edu.prj.main.MainCommand;
import co.edu.prj.member.command.AjaxIdCheck;
import co.edu.prj.member.command.Logout;
import co.edu.prj.member.command.MemberJoin;
import co.edu.prj.member.command.MemberJoinForm;
import co.edu.prj.member.command.MemberLoginForm;
import co.edu.prj.member.command.Memberlogin;

/**
 * 모든 요청을 받아들이는 컨트롤러
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	// 요청한 것을 실행하는 명령을 모아두는 곳
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand()); // 처음 보여줄 페이지 명령
		map.put("/bookList.do", new BookList()); // 책 목록보기
		map.put("/memberLoginForm.do", new MemberLoginForm()); // 로그인 폼 호출
		map.put("/memberlogin.do", new Memberlogin()); // 멤버로그인 처리
		map.put("/logout.do", new Logout()); //로그아웃
		map.put("/memberJoinForm.do", new MemberJoinForm()); //회원가입
		map.put("/ajaxIdCheck.do", new AjaxIdCheck()); //ajax를 이용한 아이디 중복체크
		map.put("/memberJoin.do", new MemberJoin()); //회원가입
		
		//jquery
		map.put("/ajaxjquery.do", new AjaxMainForm());
		map.put("/ajaxBookList.do", new AjaxBookList());

	}

	// 요청을 분석하고 실행, 결과를 돌려주는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지

		// 본격적 요청분석
		String uri = request.getRequestURI(); // 요청한 uri를 구함
		String contextPath = request.getContextPath(); // 최상위폴더:루트를 구한다.정확하게는 context ath를 구함
		String page = uri.substring(contextPath.length()); // 실제 수행할 요청을 구함

		Command command = map.get(page); // init 메소드에서 수행할 명령을 가져온다.

		// Command command = new MainCommand();
		String viewPage = command.exec(request, response); // 명령을 수행하고 결과를 돌려받음.
			
		// viewResolve 파트
		if (!viewPage.endsWith(".do") && viewPage != null) {
			// ajax 처리
			if(viewPage.startsWith("ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			// 타일즈 돌아가는곳
			if (!viewPage.endsWith(".tiles")) {
				viewPage = "/WEB-INF/views/" + viewPage + ".jsp"; // 타일즈를 안태움
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response); // 받았던 request값을 담아서 보냄
		} else {
			response.sendRedirect(viewPage); // *.do로 들어올때 돌아가는 곳. //받은 request값을 들고 가지 않음
		}
	}

}
