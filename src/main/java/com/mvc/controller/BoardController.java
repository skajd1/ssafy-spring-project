package com.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.service.BoardService;
import com.mvc.vo.Board;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping(value = {"/list"})
	public String list(Model model) {
		ArrayList<Board> list = service.selectAll();// data 받음
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping(value = "/detail") 
	public String read(Model model, @RequestParam String num) {
		
		Board b = service.selectOne(num);
		model.addAttribute("b", b);
		return "read";
	}
	@GetMapping(value = "/insert")
	public String insert() {
	
		return "insertForm";
	}
	@GetMapping(value = "/delete")
	public String delete(@RequestParam String num) {
		int x = service.delete(num);
		if (x != 0)
			return "redirect:/list";
		else {
			return "error";
		}
	}
	@GetMapping(value = "/modify")
	public String modify(Model model, @RequestParam String num, RedirectAttributes ra) {
		Board b = service.selectOne(num);
		ra.addFlashAttribute(num);
		model.addAttribute("b", b);
		return "modifyForm";
	}
	
	@PostMapping("/insertProcess")
	public String insertProcess(@ModelAttribute Board b) {
		service.insert(b);
		return "redirect:/list";
	}
	@PostMapping("/modifyProcess")
	public String modifyProcess(@ModelAttribute Board b) {
		service.modify(b);
		return "redirect:/list";
	}
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		model.addAttribute("errmsg", "잘 좀 하자 !!!<br/>" + e);
		return "error/errorPage";
	}
	@PostMapping("/search")
	public String search(@RequestParam String word, @RequestParam String condition, Model model) {
		ArrayList<Board> list = new ArrayList<>();
		HashMap<String,String> map = new HashMap<>();
		map.put("condition",condition);
		map.put("keyword",word);
		list = service.search(map);
		model.addAttribute("list", list);
		
		return "list";
	}
	@GetMapping(value = "/txtest")
	public String txtest() {
		service.txtest();
		return "redirect:/list";
	}
}
