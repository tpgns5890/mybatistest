package co.edu.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.prj.common.Command;
import co.edu.prj.member.service.MemberService;
import co.edu.prj.member.service.impl.MemberServiceImpl;

public class AjaxIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// ajax아이디 중복체크
		MemberService dao = new MemberServiceImpl();
		String id = request.getParameter("id");
		boolean b = dao.isMemberIdCheck(id);
		String result = "0";
		if(b) {
			result ="1";
		}
		return "ajax:" + result;
	}

}
