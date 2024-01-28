package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/index")
    public String home() {
        return "index";
    }
	
	@RequestMapping("/welcome")
    public String showWelcomePage(Model model) {
        List<StudentEntity> listStudent = studentService.listAll();
        model.addAttribute("listStudent", listStudent);
        return "welcome";       
    }
	
	@GetMapping("/addDetails")
    public String add(Model model) {
        model.addAttribute("StudentEntity", new StudentEntity());
        return "addDetails";
    }
	
	@PostMapping("/save")
    public String saveStudent(@ModelAttribute("StudentEntity") StudentEntity student) {
        studentService.save(student);
        return "Registered";
        
    }
	
	@GetMapping("/edit/{id}")
    public String editStudent(@PathVariable(name = "id") int id, Model model) {
        StudentEntity student = studentService.get(id);
        model.addAttribute("StudentEntity", student);
        return "addDetails"; 
    }
	
	@RequestMapping("/delete/{id}")
    public String deleteCoursePage(@PathVariable(name = "id") int id) {
    	studentService.delete(id);
        return "redirect:/welcome";
    }
	
	@RequestMapping("/about")
    public String about() {

        return "aboutProject";
    }
	

}
