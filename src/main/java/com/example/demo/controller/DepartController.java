package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Depart;
import com.example.demo.entity.User;
import com.example.demo.service.DepartService;

@Transactional
@Controller
@RequestMapping("/depart/")
public class DepartController {

	@Autowired
	DepartService dpSV;

	@RequestMapping("")
	public String index(ModelMap model,Depart dp) {
		if (dp == null) {
			dp = new Depart();
		}
		model.addAttribute("departs", dpSV.findAll());
		model.addAttribute("depart",dp);
		return "depart/index1";
 
	}

	@RequestMapping(params = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("depart") Depart dp) {
		try {
			dpSV.save(dp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/depart/";
	}

	@RequestMapping(value = "delete/{name}", method = RequestMethod.GET)
	public String delete(ModelMap model, HttpServletRequest req, @PathVariable("name") String name) {
		dpSV.delete(name);
		return "redirect:/depart/";
	}
	
	@RequestMapping(params = "update", method = RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("depart") Depart dp) {
		try {
		
			dpSV.update(dp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/depart/";
	}
	
	@RequestMapping(params = "edit", method = RequestMethod.GET)
	public String edit(ModelMap model,@RequestParam("id") String id) {
		Optional<Depart> dp = dpSV.findById(id);
		model.addAttribute("depart", dp);
		model.addAttribute("departs", dpSV.findAll());
		return "/depart/index1";
	}

	
}
