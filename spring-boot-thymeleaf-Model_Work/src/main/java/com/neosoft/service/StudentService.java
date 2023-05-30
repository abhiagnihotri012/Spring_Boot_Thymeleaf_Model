package com.neosoft.service;

import java.util.List;

import com.neosoft.entity.Software;

public interface StudentService {

	List<Software> getAllStudents();
	
	Software saveStudent(Software student);
	
	Software getStudentById(Long id);
	
	Software updateStudent(Software student);
	
	void deleteStudentById(Long id);
}
