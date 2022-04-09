/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.service;

import com.example.swp490_g25_sse.model.Course;
import com.example.swp490_g25_sse.model.Student;
import com.example.swp490_g25_sse.model.StudentCourseEnrollment;

/**
 *
 * @author Admin
 */
public interface StudentCourseEnrollmentService {

    StudentCourseEnrollment save(StudentCourseEnrollment enrollment);

    StudentCourseEnrollment getEnrollmentInfo(Student student, Course course);
}
