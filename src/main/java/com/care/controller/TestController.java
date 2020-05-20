package com.care.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController			//RequestMapping + ResponseBody, @RequestMapping 대신 @GetMapping, @PostMapping, @PutMapping, @DeleteMapping 중 아무거나 써도 상관 없음 그대신 이를 잘 사용할때는 ajax type에 맞춰서 써야한다.
public class TestController {
	
	static int aaa = 0;
	
	@GetMapping(value="ajax_result", produces="application/json;charset=utf-8")
	//@ResponseBody	//json 타입 : 키와 값으로 이루어져 있음, ajax이용할 때 꼭 써야함, 
	//json은 꼭 String type으로 돌려줘야함
	public String ajax_get() throws JsonProcessingException {
		System.out.println("ajax 실행!!!!");
		//return ++aaa + "";
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();
		UserDTO dto01 = new UserDTO();
		UserDTO dto02 = new UserDTO();
		dto01.setName("홍길동");
		dto01.setAge("20");
		dto02.setName("김개똥");
		dto02.setAge("30");
		list.add(dto01);
		list.add(dto02);
		//ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
		ObjectMapper mapper = new ObjectMapper();
		String strJson = mapper.writeValueAsString(list);
		//return "get : 데이터 요구할 때";
		return strJson;
	}
	
	@PostMapping(value="ajax_result", produces="application/text;charset=utf-8")
	//@ResponseBody	//json 타입 : 키와 값으로 이루어져 있음, ajax이용할 때 꼭 써야함
	public String ajax_post() {
		System.out.println("ajax 실행!!!!");
		//return ++aaa + "";
		return "post : 데이터 추가할 때";
	}
	
	@PutMapping(value="ajax_result", produces="application/text;charset=utf-8")
	//@ResponseBody	//json 타입 : 키와 값으로 이루어져 있음, ajax이용할 때 꼭 써야함
	public String ajax_put() {
		System.out.println("ajax 실행!!!!");
		//return ++aaa + "";
		return "put : 수정할 때";
	}
	
	@DeleteMapping(value="ajax_result", produces="application/text;charset=utf-8")
	//@ResponseBody	//json 타입 : 키와 값으로 이루어져 있음, ajax이용할 때 꼭 써야함
	public String ajax_delete() {
		System.out.println("ajax 실행!!!!");
		//return ++aaa + "";
		return "delete : 삭제할 때";
	}
//	
//	@GetMapping("user")
//	public String getUser(@RequestParam("name") String userName) { //HttpRequest로 받아도됨
//		System.out.println("넘겨 받은 사용자 이름 : " + userName);
//		return "test";
//	}
	
	@GetMapping("user/{name}")		//name은 경로로 사용한다.
	public String getUser(@PathVariable String name) { 
		System.out.println("넘겨 받은 사용자 이름 : " + name);
		return "test";
	}
	
}
