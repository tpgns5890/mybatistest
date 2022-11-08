package co.edu.prj.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.edu.prj.member.vo.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberSelectList(); 
	MemberVO memberSelect(MemberVO vo); //한명의 데이터 또는 로그인 처리
	int memberInsert(MemberVO vo);
	int memberDelete(MemberVO vo);
	int memberUpdate(MemberVO vo);
	
	MemberVO memberLogin(@Param("id") String id, @Param("passwd") String passwd);
	boolean isMemberIdCheck(String id);	//존재하면 false
	
}
