package com.saltlux.guestbook03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saltlux.guestbook03.repository.GuestbookRepository;
import com.saltlux.guestbook03.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookRepository emaillistRepository;

	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVo> list = emaillistRepository.findAll();
		model.addAttribute("list", list);
		return "WEB-INF/views/index.jsp";
	}

	@RequestMapping("/add")
	public String form(GuestbookVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping("/deleteform")
	public String deletefrom() {
		return "WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(GuestbookVo vo) {
		emaillistRepository.delete(vo);
		return "redirect:/";
	}
}
