package com.example.redis.service;

import java.util.Optional;

import com.example.redis.model.Student;
import com.example.redis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("bookServiceImpl")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	@CachePut(value = "student", key = "#student")
	public Student save(Student student) {
        return studentRepository.save(student);
	}

	@Transactional
	@Cacheable(value = "student", key = "#id")
	public Student get(int id) {
		Student student = null;
		Optional<Student> studentResponse = studentRepository.findById(id);
		if (studentResponse.isPresent()) {
			student = studentResponse.get();
		} else {
			throw new RuntimeException("Record not found");
		}
		return student;
	}

	@Transactional
	@CachePut(value = "student", key = "#student.id")
	public Student update(Student student) {
        return studentRepository.save(student);
	}

	@Transactional
	@CacheEvict(value = "student", key = "#student.id")
	public void delete(Student student) {
		studentRepository.delete(student);
	}
}