package com.neosoft.service;

import java.util.List;

import com.neosoft.entity.Employee;

public interface TeacherService {

	List<Employee> getAllTeachers();
	
	Employee saveTeacher(Employee teacher);
	
	Employee getTeacherById(Long id);
	
	Employee updateTeacher(Employee teacher);
	
	void deleteTeacherById(Long id);
}
