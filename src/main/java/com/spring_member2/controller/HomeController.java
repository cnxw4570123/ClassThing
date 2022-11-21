package com.spring_member2.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring_member2.dto.MemberDto;
import com.spring_member2.service.Mservice;

/*
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private Mservice msvc;
	@Autowired
	private HttpSession session;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/*
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "MainPage";
	}

	@RequestMapping(value = "/MemberJoinForm")
	public ModelAndView memberJoin() { // 페이지 이동만 할 경우는 String으로 반환해도 좋다.
		System.out.println("회원가입 요청");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Member/MemberJoinForm");

		return mav;
	}
	@RequestMapping(value ="/MemberLoginForm")
	public ModelAndView memberLoginForm() {
		System.out.println("로그인 요청");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Member/MemberLoginForm");
		
		return mav;
	}
	/*
	 * @RequestMapping(value="/MemberJoin") public ModelAndView
	 * memberJoin(@RequestParam(value= "testId") String mid, String testPw){ //페이지
	 * 이동만 할 경우는 String으로 반환해도 좋다. System.out.println("회원가입 요청");
	 * System.out.println("아이디 : " + mid + "\n 비밀번호 : " + testPw); ModelAndView mav
	 * = new ModelAndView(); mav.addObject("mid", mid);
	 * mav.setViewName("Member/MemberJoin");
	 * 
	 * return mav; }
	 */
	@RequestMapping(value = "/MemberJoin")
	public ModelAndView memberJoin(MemberDto member, RedirectAttributes attr) {
		ModelAndView mav = new ModelAndView();
		System.out.println("회원가입 요청");
		System.out.println(member);
		
		int insertResult = msvc.memberJoin(member);
		if(insertResult > 0) {
			//회원가입 성공
			// 1. 페이지명으로 포워딩 2. 리다이렉트
//			mav.setViewName("MainPage"); 
			mav.setViewName("redirect:/");
			attr.addFlashAttribute("msg", "회원가입에 성공했습니다.");
		}else {
			mav.setViewName("Fail");
			mav.addObject("msg","회원가입에 실패했습니다.");
		}

		return mav;
	}
	
	@RequestMapping(value="/MemberList")
	public ModelAndView memberList() {
		System.out.println("회원목록 페이지 이동요청");
		ModelAndView mav = new ModelAndView();
		
		//1. 회원 목록 조회
		ArrayList<MemberDto> memberList = msvc.memberList();
		//2. ModelAndView 객체에 저장
		mav.addObject("memberList", memberList);
		//3. 이동할 페이지 지정
		mav.setViewName("/Member/MemberList");
		return mav;
		
	}
	
	@RequestMapping(value="/MemberLogin")
	public ModelAndView memberLogin(String testId, String testPw, RedirectAttributes ra) {
		System.out.println("로그인 기능 호출");
		ModelAndView mav = new ModelAndView();
		System.out.println("아이디: " + testId + "\n" + testPw);
		String logId = msvc.MemberCheck(testId, testPw);
		if(logId != null) {
			session.setAttribute("logId", logId);
			mav.setViewName("MainPage");
		} else {
			ra.addFlashAttribute("msg", "로그인에 실패했습니다.");
			mav.setViewName("redirect:/MemberLoginForm");
//			mav.addObject("msg","로그인에 실패했습니다.");
		}
		return mav;
	}
}
