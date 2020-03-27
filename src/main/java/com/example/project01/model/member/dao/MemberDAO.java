package com.example.project01.model.member.dao;

import java.util.List;

import com.example.project01.model.member.dto.MemberDTO;

public interface MemberDAO {
	public boolean loginCheck(MemberDTO dto);
	public MemberDTO viewMember(String userid);
	public List<MemberDTO> list();
	public void join(MemberDTO dto);
	public boolean checkPw(String userid, String passwd);
	public void updateMember(MemberDTO dto);
	public void deleteMember(String userid);
	public int userid_check(String userid);

}
