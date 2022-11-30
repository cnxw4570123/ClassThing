package com.MemberBoard001.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MemberBoard001.dto.MemberDto;
import com.MemberBoard001.service.Mservice;


@Controller
public class MemberController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private Mservice msvc;
	
	@RequestMapping(value="/MemberJoinForm")
	public ModelAndView memberJoinForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Member/MemberJoinForm");
		return mav;
	}
	
	@RequestMapping(value="/MemberJoin")
	public ModelAndView memberJoin(MemberDto member) throws IllegalStateException, IOException {
		System.out.println("호원가입 요청");
		ModelAndView mav = new ModelAndView();
		//1. 회원정보 parameter 확인
		System.out.println(member);
		System.out.println(member.getMfile().getOriginalFilename());
		//2. 회원정보 서비스 요청
		int insertRs = msvc.memberJoin(member);
		
		if(insertRs > 0) {
			System.out.println("회원가입 성공");
			mav.setViewName("redirect:/");
		} else {
			System.out.println("회원가입 실패");
			mav.setViewName("redirect:/memberJoin");
		}
		return mav;
		
	}
	
	@RequestMapping(value="MemberIdCheck")
	public @ResponseBody String memberIdCheck(String inputID) {
		System.out.println("아이디 중복 체크 확인 요청");
		System.out.println("입력한 아이디 : " + inputID);
		
		//1. 아이디 중복 확인 기능 호출
		String idcResult = msvc.memberIdCheck(inputID);
		return idcResult;
	}
	
	@RequestMapping(value="MemberLoginForm")
	public ModelAndView memberLoginForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Member/MemberLoginForm");
		return mav;
	}
	
	@RequestMapping(value="MemberLogin")
	public ModelAndView memberLogin(String mid, String mpw, RedirectAttributes ra) {
		System.out.println("로그인 기능요청");
		ModelAndView mav = new ModelAndView();
		//1. 로그인 정보(mid, mpw) 받아오기
		System.out.println("mid : " + mid + "\nmpw : " + mpw);
		//2. 서버에서 select실행
		MemberDto member = msvc.getMemberLogin(mid, mpw);
//		System.out.println(member.toString());
		//3. 로그인 성공 여부에 따라 다른 페이지
		if(member != null) { // 로그인 성공 시
			System.out.println("로그인 성공");
//			session.setAttribute("userInfo", member); //Class객체를 세션에 저장시 매 리로드마다 초기화됨.
			session.setAttribute("loginID", member.getMid());
			session.setAttribute("loginProfile", member.getMprofile());
			ra.addFlashAttribute("msg", "로그인에 성공했습니다.");
			mav.setViewName("redirect:/");
		}else { // 로그인 실패 시
			System.out.println("로그인 실패");
			mav.setViewName("redirect:/MemberLoginForm");
			ra.addFlashAttribute("msg", "로그인에 실패했습니다.");
		}
		return mav;
	}
	
	@RequestMapping(value="MemberInfo")
	public ModelAndView memberInfo() {
		ModelAndView mav = new ModelAndView();
		String id = (String) session.getAttribute("loginID");//세션에 있는 아이디 추출
		MemberDto member = msvc.getMemberInfo(id); //세션 아이디로 select 수행
		mav.addObject("memberInfo", member);
		mav.setViewName("Member/MemberInfo");
		return mav;
	}
	
	@RequestMapping(value="MemberLogout")
	public ModelAndView memberLogout() {
		ModelAndView mav = new ModelAndView();
		session.invalidate();
//		session.removeAttribute("loginID");
//		session.removeAttribute("loginProfile");
		mav.setViewName("Main");
		return mav;
	}
}
