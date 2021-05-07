package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberservice;
	
	//회원가입
	@PostMapping("/join")
	public String join(MemberDto memberDto) throws Exception {
		memberservice.registerMember(memberDto);
		return "/";
	}
	
	@GetMapping("/join")
	public String join() {
		return "signUp";
	}
	
	//로그인
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, HttpSession session) throws Exception {
		MemberDto memberDto = memberservice.login(map);
		session.setAttribute("userinfo", memberDto);
		return "redirect:/";
	}
	
	@PostMapping("/modify")
	public String modify(MemberDto memberDto, HttpSession session) throws Exception {
		memberservice.modifyMember(memberDto);
		session.setAttribute("userinfo", memberDto );
		return "redirect:/";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("userId") String userId, HttpSession session) throws Exception {
		memberservice.deleteMember(userId);
		session.setAttribute("userinfo", null);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.setAttribute("userinfo", null);
		return "redirect:/";
	}
	
	@PostMapping("/addInterest")
	public ResponseEntity<Boolean> addInterest(@RequestBody Map<String, String> map, HttpSession session) throws Exception {
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		//Map<String, String> map = new HashMap<String, String>();
		
		
		System.out.println(memberDto.getUserId());
		System.out.println(map.get("gugun"));
		System.out.println(map.get("dong"));
		
		map.put("userId", memberDto.getUserId());
		//map.put("gugun", gugun);
		//map.put("dong", dong);
		memberservice.addInterest(map);
		
		List<String> list = memberDto.getInterest();
		list.add(map.get("gugun")+" "+map.get("dong"));
		memberDto.setInterest(list);
		
		
		session.setAttribute("userinfo", memberDto);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@PostMapping("/removeInterest")
	public ResponseEntity<Boolean> removeInterest(@RequestBody Map<String, String> map, HttpSession session) throws Exception {
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
				
		System.out.println(memberDto.getUserId());
		System.out.println(map.get("gugun"));
		System.out.println(map.get("dong"));
		
		map.put("userId", memberDto.getUserId());	
		memberservice.removeInterest(map);
		
		List<String> list = memberDto.getInterest();
		list.remove(map.get("gugun")+" "+map.get("dong"));
		memberDto.setInterest(list);
		
		
		session.setAttribute("userinfo", memberDto);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
