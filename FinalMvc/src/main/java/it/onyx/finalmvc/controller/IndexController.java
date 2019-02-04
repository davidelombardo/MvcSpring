package it.onyx.finalmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.onyx.finalmvc.dao.DaoMvc;
import it.onyx.finalmvc.util.UtilMvc;

@Controller
public class IndexController {
	String email, password, nome, cognome, numero, passwordError, userNotFound;
	
	@RequestMapping(value="/")
	public String savePerson(@ModelAttribute DaoMvc daoMvc, Model model) {
		return "index";
	}
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String savePersonPost(@ModelAttribute DaoMvc daoMvc, Model model) {
		email= daoMvc.getEmail();
		password=daoMvc.getPassword();
		daoMvc = UtilMvc.login(email, password);
		if(email!=null && !email.equals("")) {
			if( password!=null && !password.equals("")) {
			return "redirect:/home";
		}
			else
				model.addAttribute("passwordErrata","password errata" );
				return"index";
		} else
			model.addAttribute("emailErrata", "Email Errata");
			return "index";
		
		
		
		
	}


}
