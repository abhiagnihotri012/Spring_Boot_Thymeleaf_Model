package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.entity.Software;
import com.neosoft.repository.SoftwareRepository;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private SoftwareRepository studentRepository;	
	
	@Override
	public List<Software> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Software saveStudent(Software student) {
		return studentRepository.save(student);
	}

	@Override
	public Software getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Software updateStudent(Software student) {		
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);	
	}
}
