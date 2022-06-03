package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.dao.RoleRepository;
import com.demo.dao.StaffRepository;
import com.demo.ds.Role;
import com.demo.ds.Staff;

@Controller
public class StaffController {
	@Autowired
	private StaffRepository staffRepo;
	@Autowired
	private RoleRepository roleRepo;
	
	@GetMapping({"/index","/"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/staff")
	public String createStaffForm(Model model) {
		List<Role> listRole =  roleRepo.findAll();
		model.addAttribute("listRole",listRole);
		model.addAttribute("staff", new Staff());
		return "staffForm";
	}
	@PostMapping("/staff/create")
	public String saveStaff(Staff staff) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPass = encoder.encode(staff.getPassword());
		staff.setPassword(encodedPass);
		staffRepo.save(staff);
		
		return "redirect:/staff/all";
	}
	
	@GetMapping("/staff/all")
	public String showStaff(Model model) {
		List<Staff> listStaff = staffRepo.findAll();
		model.addAttribute("listStaff", listStaff);
		return "staffs";
	}
	
	@GetMapping("/staff/edit/{id}")
	public String showEditStaffForm(@PathVariable("id")Integer id, Model model) {
		Staff staff = staffRepo.findById(id).get();
		model.addAttribute("staff",staff);
		
		List<Role> listRole = roleRepo.findAll();
		model.addAttribute("listRole", listRole);
		
		return "updateStaffForm";
	}
	
	@PostMapping("/staff/update/{id}")
	public String UpdateStaffForm(@PathVariable("id")Integer id,Staff staff,BindingResult result, Model model) {
		if (result.hasErrors()){
            staff.setId(id);
            return "updateStaffForm";
        }
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPass = encoder.encode(staff.getPassword());
		staff.setPassword(encodedPass);
		staffRepo.save(staff);
			
		return "redirect:/staff/all";
	}
	
	
	
}
