package co.edu.prj.member.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.edu.prj.common.DataSource;
import co.edu.prj.member.mapper.MemberMapper;
import co.edu.prj.member.service.MemberService;
import co.edu.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true); //오토 커밋
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class); //데이터베이스 연결후 커넥션 호출
	@Override
	public List<MemberVO> memberSelectList() {
		// TODO Auto-generated method stub
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberInsert(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberDelete(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberUpdate(vo);
	}

	@Override
	public MemberVO memberLogin(String id, String passwd) {
		// TODO Auto-generated method stub
		return map.memberLogin(id, passwd);
	}

	@Override
	public boolean isMemberIdCheck(String id) {
		return map.isMemberIdCheck(id);
	}

}
