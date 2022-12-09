package com.MemberBoard001.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.MemberBoard001.dto.TagoDto;
import com.MemberBoard001.service.ApiService;

@Controller
public class ApiController {
	
	@Autowired
	private ApiService apisvc;
	
	@Autowired
	private HttpSession session;
	
	/*
	 * @RequestMapping(value="/KakaoLogin") public ModelAndView kakaoLogin(String
	 * code) throws Exception { System.out.println("카카오 로그인 기능 호출"); ModelAndView
	 * mav = new ModelAndView(); //인가 코드 응답 받음 System.out.println("코드 : " + code);
	 * String kakaoAccessToken = apisvc.getAccToken(code);
	 * System.out.println("kakaoAccToken : "+kakaoAccessToken); return mav; }
	 */
	
	@RequestMapping(value="/kakaoPay_Ready")
	public ModelAndView kakaoPay_ready(String prcode, int prprice, String prname, int prqty) throws Exception {
		System.out.println("카카오페이 결제 요청");
		ModelAndView mav = new ModelAndView();
		String nextPcUrl = apisvc.kakaoPay_ready(prcode, prname, prprice, prqty);
		System.out.println("nextPcUrl: " + nextPcUrl);
		mav.setViewName("redirect:" + nextPcUrl);
		return mav;
	}
	
	@RequestMapping(value="/KakaoPay_go")
	public ModelAndView kakaoPay_go() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("APIs/Kakaopay_test");
		return mav;
	}
	
	@RequestMapping(value="/kakaoPay_approval")
	public ModelAndView kakaoPay_approval(String pg_token) throws Exception{
		ModelAndView mav = new ModelAndView();
		System.out.println("_approval");
		System.out.println("pg_token : " + pg_token);
		String tid = (String)session.getAttribute("payTid");
		System.out.println("tid : " + tid);
		
		String[] payResult = apisvc.kakaopay_approval(tid, pg_token);
		if(payResult != null) {
			mav.addObject("result", payResult);
			mav.setViewName("APIs/kakaoPayTestPage");
		} else {
			mav.setViewName("redirect:/KakaoPay_go");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/Tago_Test")
	public ModelAndView tago_test() {
		System.out.println("버스도착 정보 페이지 호출");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("APIs/TagoTest");
		return mav;
	}
	
	@RequestMapping(value="/Tago_get_data")
	public @ResponseBody String tago_get_data(TagoDto tagoData) throws Exception{
		String data = apisvc.tagoGetData(tagoData);
		System.out.println(data);
		return data;
	}
	
}
