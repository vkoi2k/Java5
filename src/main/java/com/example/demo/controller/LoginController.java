package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.example.demo.service.UserService;

@Transactional
@Controller
@RequestMapping("/login/")
public class LoginController {

	@Autowired
	UserService usSV;

	@RequestMapping("")
	public String index(ModelMap model) {
		model.addAttribute("user", new User());
		return "index/login";

	}

	@RequestMapping(params = "login", method = RequestMethod.POST)
	public String login(Session ss, ModelMap model, HttpServletRequest req, @ModelAttribute("user") User dp) {
		Optional<User> us = usSV.findById(dp.getUsername());
		try {
			HttpSession session = req.getSession();
			if (us.get().getPassword().equals(dp.getPassword())) {
				session.setAttribute("userlogin", us);
				return "redirect:/index/";
			} else {
				model.put("mes", "Sai tài khoản hoặc mật khẩu");
				return "redirect:/login/";
			}
		} catch (Exception e) {
			model.put("mes", "Sai tài khoản hoặc mật khẩu");
			return "index/login";
		}

	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logOut(ModelMap model,HttpServletRequest req, @ModelAttribute("user") User dp) {
		try {
			HttpSession session = req.getSession();
			session.invalidate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index/index";
		
	}

	@RequestMapping(value = "delete/{name}", method = RequestMethod.GET)
	public String delete(ModelMap model, HttpServletRequest req, @PathVariable("name") String name) {
		usSV.delete(name);
		return "redirect:/depart/";
	}

}
