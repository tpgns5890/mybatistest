package co.edu.prj.member.service;

import java.util.List;

import co.edu.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList(); 
	MemberVO memberSelect(MemberVO vo); //한명의 데이터 또는 로그인 처리
	int memberInsert(MemberVO vo);
	int memberDelete(MemberVO vo);
	int memberUpdate(MemberVO vo);
	
	MemberVO memberLogin(String id, String passwd);
	boolean isMemberIdCheck(String id);	//존재하면 false
	
}
