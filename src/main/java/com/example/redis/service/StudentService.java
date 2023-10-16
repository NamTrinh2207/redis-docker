package com.example.redis.service;

import com.example.redis.model.Student;
import org.springframework.stereotype.Component;


@Component
public interface StudentService {
	public Student save(Student student);

	public Student update(Student student);

	public Student get(int id);

	public void delete(Student student);
}