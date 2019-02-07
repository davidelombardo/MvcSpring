package it.onyx.finalmvc.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.onyx.finalmvc.dao.DaoMvc;

@Controller
public class WelcomeMvc {
	
	@RequestMapping(value="home")
	public String welcome(@ModelAttribute DaoMvc daoMvc, Model model, @ModelAttribute("daoMvc") DaoMvc daoc, RedirectAttributes redAtt) {			
		model.addAttribute("email",daoc.getEmail());
		model.addAttribute("password",daoc.getPassword());
		return "home";
	}

}
