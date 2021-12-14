package com.neosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.neosoft.entity.Teacher;
import com.neosoft.service.TeacherServiceImpl;

@Controller
public class TeacherController {

	@Autowired
	private TeacherServiceImpl TeacherServiceImpl;
	
	@GetMapping("/teachers")
	public String listteachers(Model model) {
		
		model.addAttribute("teachers",TeacherServiceImpl.getAllTeachers());
		
		return "teachers";
	}
	
	@GetMapping("/teachers/new")
	public String createteacherForm(Model model) {
		
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		
		return "create_teacher";
	}
	
	@PostMapping("/teachers")
	public String saveteacher(@ModelAttribute("teacher") Teacher teacher) {
		
		TeacherServiceImpl.saveTeacher(teacher);
		
		return "redirect:/teachers";
	}
	
	@GetMapping("/teachers/edit/{id}")
	public String editteacherForm(@PathVariable Long id, Model model) {
		
		model.addAttribute("teacher",TeacherServiceImpl.getTeacherById(id));
		
		return "edit_teacher";
	}
	
	@PostMapping("/teachers/{id}")
	public String updateteacher(@PathVariable Long id, 
			@ModelAttribute("teacher") Teacher teacher,	Model model) {
		
		Teacher existingteacher = TeacherServiceImpl.getTeacherById(id);
		existingteacher.setId(id);
		existingteacher.setFirstName(teacher.getFirstName());
		existingteacher.setLastName(teacher.getLastName());
		existingteacher.setEmail(teacher.getEmail());		
		TeacherServiceImpl.updateTeacher(existingteacher);
		
		return "redirect:/teachers";
	}
	
	@GetMapping("/teachers/{id}")
	public String deleteteacher(@PathVariable Long id) {
		
		TeacherServiceImpl.deleteTeacherById(id);
		
		return "redirect:/teachers";
	}	
}
