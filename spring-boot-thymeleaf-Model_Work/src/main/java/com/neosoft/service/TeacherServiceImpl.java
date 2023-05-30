package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.entity.Employee;
import com.neosoft.repository.EmpoyeeRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private EmpoyeeRepository teacherRepository;	
	
	@Override
	public List<Employee> getAllTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public Employee saveTeacher(Employee teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public Employee getTeacherById(Long id) {
		return teacherRepository.findById(id).get();
	}

	@Override
	public Employee updateTeacher(Employee Teacher) {		
		return teacherRepository.save(Teacher);
	}

	@Override
	public void deleteTeacherById(Long id) {
		teacherRepository.deleteById(id);	
	}
}
