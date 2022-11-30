package com.in28minutes.learnspringboot.course.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.learnspringboot.course.bean.Course;
import com.in28minutes.learnspringboot.course.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository repository;
	
	// http://localhost:8080/courses
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		
		
		return repository.findAll();
		
//		return Arrays.asList(new Course(1, "Learn Microservices", "in28minutes"),new Course(2, "Learn Full Stack w React", "in28minutes"));
	}

	
	// http://localhost:8080/courses/1
	@GetMapping("/courses/{id}")
	public Course getCourseDetails(@PathVariable long id) {
		
		Optional<Course> course = repository.findById(id);
		if (course.isEmpty()) {
			throw new RuntimeException ("Course not found with id " + id);
		}
		
		return course.get();
		
//		return new Course(1, "Learn Microservices 1", "in28minutes");
	}
	
//	GET - Retrieve information (/courses, /courses/1)
//	POST - Create a new resource (/courses)
//	PUT - Update/Replace a resources (/courses/1)
//	DELETE - Delete a resource (/courses/1)
	
}