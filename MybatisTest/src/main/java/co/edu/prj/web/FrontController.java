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

import co.edu.prj.book.command.BookList;
import co.edu.prj.common.Command;
import co.edu.prj.main.MainCommand;

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

    //요청한 것을 실행하는 명령을 모아두는 곳
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand()); //처음 보여줄 페이지 명령
		map.put("/bookList.do", new BookList());
		
	}

	//요청을 분석하고 실행, 결과를 돌려주는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //한글 깨짐 방지
		
		//본격적 요청분석
		String uri = request.getRequestURI(); //요청한 uri를 구함
		String contextPath = request.getContextPath(); //최상위폴더:루트를 구한다.정확하게는 context ath를 구함
		String page = uri.substring(contextPath.length()); //실제 수행할 요청을 구함
		
		Command command = map.get(page); //init 메소드에서 수행할 명령을 가져온다.
		
		//Command command = new MainCommand();
		String viewPage = command.exec(request, response); //명령을 수행하고 결과를 돌려받음.
		
		//viewResolve 파트
		if(!viewPage.endsWith(".do") && viewPage != null) {
			//ajax 처리 
			
			//타일즈 돌아가는곳
			viewPage = "/WEB-INF/views/" + viewPage + ".jsp"; //.do가아니면 직접 설정
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response); //받았던 request값을 담아서 보냄
		}else {
			response.sendRedirect(viewPage); //*.do로 들어올때 돌아가는 곳. //받은 request값을 들고 가지 않음
		}		
	}

}
