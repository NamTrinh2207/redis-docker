package com.example.redis.controller;

import com.example.redis.model.Student;
import com.example.redis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
        return studentService.save(student);
	}

	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable int id) {
        return studentService.get(id);
	}

	@DeleteMapping("/delete")
	public String deleteStudent(@RequestBody Student student) {
		studentService.delete(student);
		return "Record deleted succesfully";
	}
}