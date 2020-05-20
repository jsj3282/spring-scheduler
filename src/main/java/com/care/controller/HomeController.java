package com.care.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	static int cnt = 0;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("non_ajax")
	public String test() {
		System.out.println("실행!!!");
		//non_ajax : 페이지를 전체 다시 로드 ex) 좋아요 버튼 누르면 하트로만 바뀜
		return "non_ajax";
	}
	
	@RequestMapping("ajax")
	public String ajax() {
		System.out.println("ajax 실행!!!");
		//non_ajax : 페이지를 전체 다시 로드 ex) 좋아요 버튼 누르면 하트로만 바뀜
		return "ajax";
	}
	
//	@RequestMapping("ajax_result")
//	@ResponseBody	//json 타입 : 키와 값으로 이루어져 있음, ajax이용할 때 꼭 써야함
//	public String ajax_result() {
//		System.out.println("ajax 실행!!!!");
//		return ++cnt + "";
//	}
}
