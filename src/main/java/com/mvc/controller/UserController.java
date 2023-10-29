package com.mvc.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.service.UserService;
import com.mvc.vo.User;
//FC=>UC=>US
@Controller
public class UserController {
	private UserService service;
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	
	//로그인 화면
	@GetMapping("/login")
	public String login() {
		return "loginForm";
	}
	@PostMapping("/loginProcess")
	public String loginProcess(@RequestParam("id") String id, @RequestParam("pw") String pw, String remember, HttpSession session, HttpServletResponse response, RedirectAttributes ra) {
		//UserService에게 넘기기(id, pass)
		User u = new User(id, pw);
		boolean flag = service.check(u);
		String url = "list";
		
		if(flag) {
			//로그인 정보를 session에 저장 ("user", u)
			//세션이 없었다->새 세션 생성해서 리턴. 있었다->예전 세션 리턴
			session.setAttribute("u", u);
			if(u.getId().equals("admin")) {
				session.setAttribute("admin", 1);
			}
			else session.setAttribute("admin", 0);
			
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
		}
		
		return "redirect:/" + url;
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.setAttribute("u", null);
		session.setAttribute("admin", 0);
		
		return "redirect:/list";
	}
	@GetMapping(value = {"/list"})
	public String list(Model model) {
		ArrayList<User> list = service.selectAll();// data 받음
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping(value = "/list/{id}") 
	public String read(Model model, @PathVariable String id) {
		 User u = service.selectOne(id);
		model.addAttribute("u",u);
		return "read";
	}
	@GetMapping(value = "/insert")
	public String insert() {
	
		return "insertForm";
	}
	@GetMapping(value = "/delete")
	public String delete(@RequestParam String id) {
		service.delete(id);
		return "redirect:/list";
	}
	@GetMapping(value = "/modify")
	public String modify(Model model, @RequestParam String id, RedirectAttributes ra) {
		User u = service.selectOne(id);
		ra.addFlashAttribute(id);
		model.addAttribute("u", u);
		return "modifyForm";
	}
	@GetMapping(value = "/admin")
	public String modify() {
		return "admin";
	}
	
	@PostMapping("/insertProcess")
	public String insertProcess(@ModelAttribute User u) {
		service.insert(u);
		return "redirect:/list";
	}
	@PostMapping("/modifyProcess")
	public String modifyProcess(@ModelAttribute User u) {
		service.modify(u);
		return "redirect:/list";
	}
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		model.addAttribute("errmsg", "잘 좀 하자 !!!<br/>" + e);
		return "error/errorPage";
	}
}







