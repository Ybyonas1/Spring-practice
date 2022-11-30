package com.in28minutes.learnspringboot.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.learnspringboot.course.bean.Course;

public interface CourseRepository extends JpaRepository<Course, Long>  {

}
