package com.mvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.service.UserService;
import com.mvc.vo.User;
//FC=>UC=>US
@Controller
public class UserController {
	@Autowired
	UserService service;
	
	//로그인 화면
	@GetMapping("/login")
	public String login() {
		return "loginForm";
	}
	@PostMapping("/loginProcess")
	public String loginProcess(@RequestParam("id") String id, @RequestParam("pass") String pass, String remember, HttpSession session, HttpServletResponse response, RedirectAttributes ra) {
		//UserService에게 넘기기(id, pass)
		User u = new User(id, pass);
		boolean flag = service.check(u);
		String url = "list";
		
		if(flag) {
			//로그인 정보를 session에 저장 ("user", u)
			//세션이 없었다->새 세션 생성해서 리턴. 있었다->예전 세션 리턴
			session.setAttribute("user", u);			
			
			//cookie 처리
			if(remember != null) {//체크박스 체크한 경우		
				Cookie remem = new Cookie("remember", id);
				remem.setMaxAge(-1);
				response.addCookie(remem);
				
			}else {//체크박스 체크하지 않은 경우
				//유효하지 않은 쿠키로 설정하기
				Cookie remem = new Cookie("remember", null);				
				remem.setMaxAge(0); // 유효기간을 0으로. 쿠키저장 안하는 효과
				response.addCookie(remem);
			}	
			
		}
		else {
			url = "login";
			ra.addFlashAttribute("error", "사용자 id/pw를 확인해요");
			ra.addAttribute("xyz", "seoul");
		}
		
		return "redirect:/" + url;
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		
		return "redirect:/list";
	}
}







