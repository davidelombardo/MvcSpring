package it.onyx.finalmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.onyx.finalmvc.dao.DaoMvc;
import it.onyx.finalmvc.hibernate.HibernateConf;

@Controller
public class RegMvc {
	String email, password, nome, cognome, numero;
	@RequestMapping(value="/registration")
	public String regUser(@ModelAttribute DaoMvc daoMvc, Model model) {
		return "/registration";
	}
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String reg(@ModelAttribute DaoMvc daoMvc, Model model) {
		nome=daoMvc.getNome();
		cognome=daoMvc.getCognome();
		numero=daoMvc.getNum_telefono();
		email=daoMvc.getEmail();
		password= daoMvc.getPassword();
		HibernateConf.insert(daoMvc);
		return "redirect:/";
	}
	

}
