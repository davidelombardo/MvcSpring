package it.onyx.finalmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.onyx.finalmvc.dao.DaoMvc;
import it.onyx.finalmvc.hibernate.HibernateConf;

@Controller
public class IndexController {
	String email, password, nome, cognome, numero;
	
	@RequestMapping(value="/")
	public String savePerson(@ModelAttribute DaoMvc daoMvc, Model model) {
		return "index";
	}
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String savePersonPost(@ModelAttribute DaoMvc daoMvc, Model model, RedirectAttributes redAtt) {
		email= daoMvc.getEmail();
		password=daoMvc.getPassword();
		nome= daoMvc.getNome();
		cognome = daoMvc.getCognome();
		numero = daoMvc.getNum_telefono();
		
		if(email!=null && !email.equals("")) {
			if( password!=null && !password.equals("")) { 
					HibernateConf.select(email, password);
					redAtt.addFlashAttribute("email", email);
					redAtt.addFlashAttribute("password", password);
			
			return "redirect:/home";
	
			}else
				model.addAttribute("passwordErrata","password errata" );
				return"index";
		} else
			model.addAttribute("emailErrata", "Email Errata");
			return "index";
	}
	
	
	


}
