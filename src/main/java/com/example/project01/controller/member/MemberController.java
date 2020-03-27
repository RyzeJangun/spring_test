package com.example.project01.controller.member;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.project01.model.member.dto.MemberDTO;
import com.example.project01.service.member.MemberService;

@Controller
@RequestMapping("member/*") //공통 url
public class MemberController {
	//로깅처리
	private static final Logger logger=
			LoggerFactory.getLogger(MemberController.class);
	@Inject
	MemberService memberService;
	
	//1.회원가입 경로
	@RequestMapping("join_route.do")
	public String join_route() {
		return "member/join";
	}
	
	//2.회원가입
	@RequestMapping("join.do")
	public String join(@ModelAttribute MemberDTO dto) {
		memberService.join(dto);//create method 눌러
		return "redirect:/member/login.do";
	}
	
	//아이디 중복체크
	@RequestMapping(value="userid_check.do", method = RequestMethod.GET)
	@ResponseBody
	public int userid_check(String userid) {
		System.out.println(userid);
		return memberService.userid_check(userid);
	}
	
	
	//3.로그인 경로
	@RequestMapping("login.do") //세부 url
	public String login() {
		return "member/login"; //login.jsp로 이동
	}
	
	
	//4.로그인 체크	
	@RequestMapping("login_check.do")
	public ModelAndView login_check(MemberDTO dto, 
			HttpSession session) {
		//로그인 성공 true, 실패 false
		boolean result=memberService.loginCheck(dto, session);
		ModelAndView mav=new ModelAndView();
		if(result) {//로그인 성공
			mav.setViewName("home");
		}else {//로그인 실패
			mav.setViewName("member/login");
			//뷰에 전달할 값
			mav.addObject("message", "error");
		}
		return mav;
	}//login_check()
	
	//5.로그아웃
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session,ModelAndView mav) {
		//세션초기화
		memberService.logout(session);
		//login.jsp로 이동
		mav.setViewName("member/login");
		mav.addObject("message", "logout");
		return mav;
	}
	
	//관리자권한 회원정보리스트
	@RequestMapping("memberList.do")
	public String list(Model model) {
		List<MemberDTO> list=memberService.list();		
		model.addAttribute("list", list);
		return "member/member_list";
	}
	
	//회원수정관련
		@RequestMapping("member/view.do")
		public String view(@RequestParam String userid, Model model) {
			//모델에 자료 저장
			model.addAttribute("dto", memberService.viewMember(userid));
			return "member/view";//view.jsp로 포워딩
		}
	
	//회원수정
		@RequestMapping("member/update.do")
		public String update(MemberDTO dto, Model model) {
			//비밀번호 체크
			boolean result=memberService.checkPw(dto.getUserid(), dto.getPasswd());//create method
			if(result) {//비밀번호가 맞으면
				//회원정보 수정
				memberService.updateMember(dto);//create method
				//수정 후 목록으로 이동
				return "redirect:/member/memberList.do";
			}else {//비밀번호가 틀리면
				model.addAttribute("dto", dto);
				model.addAttribute("join_date", 
						memberService.viewMember(dto.getUserid()).getJoin_date());
				model.addAttribute("message", "비밀번호를 확인하세요.");
				return "member/view";
			}
			
		}//update()
	
		//회원삭제
		@RequestMapping("member/delete.do")
		public String delete(String userid, String passwd, Model model) {
			boolean result=memberService.checkPw(userid, passwd);
			if(result) {//비번이 맞으면 삭제 => 목록으로 이동
				memberService.deleteMember(userid);
				return "redirect:/member/list.do";
			}else {//비번이 틀리면 되돌아감
				model.addAttribute("message", "비밀번호를 확인하세요.");
				model.addAttribute("dto", memberService.viewMember(userid));
				return "member/view";
			}
		}
	


}
