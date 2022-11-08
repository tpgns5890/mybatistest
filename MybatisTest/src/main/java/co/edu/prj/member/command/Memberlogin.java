package co.edu.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.prj.common.Command;
import co.edu.prj.member.service.MemberService;
import co.edu.prj.member.service.impl.MemberServiceImpl;
import co.edu.prj.member.vo.MemberVO;

public class Memberlogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//로그인 처리
		MemberService dao = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		HttpSession session = request.getSession(); //세션 유지를 위한 세션값 사용하기 위해 사용
		String id = request.getParameter("id");//form에서 넘어오는 name속성에 담긴 이름
		String password = request.getParameter("passwd");
		String message = "아이디 또는 패스워드가 틀립니다.";
		member = dao.memberLogin(id, password);
		if(member != null) {
			session.setAttribute("id", member.getId());
			session.setAttribute("name", member.getName());
			session.setAttribute("responsibility", member.getResponsibility());
			message = member.getName() + "님 환영합니다.";
		}
		
		request.setAttribute("message", message);
		return "member/memberLogin.tiles";
	}

}
