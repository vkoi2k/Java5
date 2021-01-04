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
import com.example.demo.entity.Record;
import com.example.demo.service.StaffService;
import com.example.demo.service.DepartService;
import com.example.demo.service.RecordService;

@Transactional
@Controller
@RequestMapping("/record/")
public class RecordController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	StaffService stSV;

	@Autowired
	RecordService rcSV;

	
	@Autowired
	DepartService dpSV;

	@RequestMapping("")
	public String index(ModelMap model, Record dp) {
		if (dp == null) {
			dp = new Record();
		}
		model.addAttribute("staffs", stSV.findAll());
		model.addAttribute("departs", dpSV.findAll());
		model.addAttribute("record", dp);
		return "records/index1";

	}

	@RequestMapping("history")
	public String rcHistory(ModelMap model) {
		model.addAttribute("records", rcSV.findAll());
		return "records/history";

	}
	
	@RequestMapping(params = "thanhTich", method = RequestMethod.POST)
	public String insert(ModelMap model, HttpServletRequest req, @ModelAttribute("record") Record staff) {
		try {
			String date = (String) req.getParameter("dates");
			staff.setDate(sdf.parse(date));
			staff.setType(true);
			rcSV.save(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/record/";
	}
	

	@RequestMapping(params = "kyLuat", method = RequestMethod.POST)
	public String kyLuat(ModelMap model, HttpServletRequest req, @ModelAttribute("record") Record staff) {
		try {
			String date = (String) req.getParameter("dates");
			staff.setDate(sdf.parse(date));
			staff.setType(false);
			rcSV.save(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/record/";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(ModelMap model, HttpServletRequest req, @PathVariable("id") String id) {
		try {
			stSV.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/record/";
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
		return "redirect:/record/";
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
