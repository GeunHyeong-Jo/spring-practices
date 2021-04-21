package com.saltlux.guestbook03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value = "/deleteform", method = RequestMethod.POST)
	public String delete(String no, Model model) {
		System.out.println(no);
		model.addAttribute("no", no);
		return "WEB-INF/views/deleteform.jsp";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(GuestbookVo vo) {
		System.out.println(vo);
		emaillistRepository.delete(vo);
		return "redirect:/";
	}

	@RequestMapping("/insert")
	public String form(GuestbookVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";
	}
}
