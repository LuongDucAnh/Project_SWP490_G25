/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.service;

import com.example.swp490_g25_sse.dto.CourseDto;
import com.example.swp490_g25_sse.model.Course;
import com.example.swp490_g25_sse.model.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

/**
 *
 * @author Admin
 */
public interface CourseService {

	Optional<Course> getCourseById(long id);

	Course createCourse(CourseDto courseDto);

	List<Course> getCourses();

	Optional<Course> deleteCourse(long id);

	Course updateCourse(CourseDto courseDto, long id);

	Page<Course> getMostEnrolledCourses();
        
        Boolean isAlreadyEnrolled(Course course, Student student);
}
