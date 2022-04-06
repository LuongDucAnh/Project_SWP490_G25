/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.repository;

import com.example.swp490_g25_sse.model.Course;
import com.example.swp490_g25_sse.model.Student;
import com.example.swp490_g25_sse.model.StudentCourseEnrollment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Admin
 */
public interface StudentCourseEnrollmentRepository extends JpaRepository<StudentCourseEnrollment, Long> {
   StudentCourseEnrollment findFirstByStudentAndCourse(Student student, Course course);

   Page<StudentCourseEnrollment> findByStudentAndIsFinished(Student student, Boolean isFinished, Pageable pageable);
}
