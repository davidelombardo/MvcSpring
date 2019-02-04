package it.onyx.finalmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it.onyx.finalmvc.dao.DaoMvc;

@Controller
public class WelcomeMvc {
	
	@RequestMapping(value="home")
	public String welcome(@ModelAttribute DaoMvc daoMvc, Model model) {	
		System.out.println("homepage" +  daoMvc.getEmail());
		model.addAttribute("email", "email");
		model.addAttribute("email", daoMvc.getEmail());
		model.addAttribute("password",daoMvc.getPassword());
		return "home";
	}

}
