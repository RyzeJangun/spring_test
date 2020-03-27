package com.example.project01.service.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.project01.model.member.dto.MemberDTO;

public interface MemberService {
	public boolean loginCheck(MemberDTO dto, HttpSession session);
	public void logout(HttpSession session);
	public MemberDTO viewMember(String userid);
	public List<MemberDTO> list();
	public void join(MemberDTO dto);
	public boolean checkPw(String userid, String passwd);
	public void updateMember(MemberDTO dto);
	public void deleteMember(String userid);
	public int userid_check(String userid);
}
