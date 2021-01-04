package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
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

import com.example.demo.entity.Staff;
import com.example.demo.entity.Depart;
import com.example.demo.entity.User;
import com.example.demo.service.StaffService;
import com.example.demo.service.DepartService;

@Transactional
@Controller
@RequestMapping("/staff/")
public class StaffController {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	StaffService stSV;

	@Autowired
	DepartService dpSV;

	@RequestMapping("")
	public String index(ModelMap model, Staff dp) {
		if (dp == null) {
			dp = new Staff();
		}
		model.addAttribute("staffs", stSV.findAll());
		model.addAttribute("departs", dpSV.findAll());
		model.addAttribute("staff", dp);
		return "staffs/index1";

	}

	@RequestMapping(params = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, HttpServletRequest req, @ModelAttribute("staff") Staff staff) {
		try {
			String id = (String) req.getParameter("departs");
			String birthday = (String) req.getParameter("birthday");
			Optional<Depart> dp = dpSV.findById(id);
			staff.setDepart_id(dp.get());
			staff.setBirthday(sdf.parse(birthday));
			stSV.save(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/staff/";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(ModelMap model, HttpServletRequest req, @PathVariable("id") String id) {
		try {
			stSV.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/staff/";
	}

	@RequestMapping(params = "update", method = RequestMethod.POST)
	public String update(ModelMap model, HttpServletRequest req, @ModelAttribute("staff") Staff staff) {
		try {
			String id = (String) req.getParameter("departs");
			String birthday = (String) req.getParameter("birthday");
			System.out.println(birthday);
			Optional<Depart> dp = dpSV.findById(id);
			staff.setDepart_id(dp.get());
			staff.setBirthday(sdf.parse(birthday));
			stSV.update(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/staff/";
	}

	@RequestMapping(params = "edit", method = RequestMethod.GET)
	public String edit(ModelMap model, @RequestParam("id") String id) {
		Optional<Staff> dp = stSV.findById(id);
		model.addAttribute("staff", dp);
		model.addAttribute("staffs", stSV.findAll());
		model.addAttribute("departs", dpSV.findAll());
		return "/staffs/index1";
	}

}
