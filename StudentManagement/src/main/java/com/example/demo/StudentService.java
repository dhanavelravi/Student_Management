package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	public List<StudentEntity> listAll() {
        return studentDAO.findAll();
    }
	
	 public void save(StudentEntity student) {
		 studentDAO.save(student);
	    }
	 
	 public StudentEntity get(long id) {
	        return studentDAO.findById(id).get();
	    }
	 
	 public void delete(long id) {
		 studentDAO.deleteById(id);
	    }

}
