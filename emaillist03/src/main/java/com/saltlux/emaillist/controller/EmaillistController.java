package com.saltlux.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saltlux.emaillist.vo.EmaillistVo;
import com.saltlux.emailllist.repository.EmaillistRepository;

@Controller
public class EmaillistController {

	@Autowired
	private EmaillistRepository emaillistRepository;

	@RequestMapping("")
	public String index(Model model) {
		List<EmaillistVo> list = emaillistRepository.findAll();
		model.addAttribute("list", list);
		return "WEB-INF/views/index.jsp";
	}

	@RequestMapping("/form")
	public String form() {
		return "WEB-INF/views/form.jsp";
	}

	@RequestMapping("/add")
	public String form(EmaillistVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";
	}
}
