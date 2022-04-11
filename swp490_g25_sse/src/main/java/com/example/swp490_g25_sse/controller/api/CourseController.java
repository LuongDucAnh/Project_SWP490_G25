/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.controller.api;

import com.example.swp490_g25_sse.dto.CourseDto;
import com.example.swp490_g25_sse.dto.LectureDto;
import com.example.swp490_g25_sse.exception.BaseRestException;
import com.example.swp490_g25_sse.model.Course;
import com.example.swp490_g25_sse.model.LectureResult;
import com.example.swp490_g25_sse.model.Student;
import com.example.swp490_g25_sse.model.StudentCourseEnrollment;
import com.example.swp490_g25_sse.model.Teacher;
import com.example.swp490_g25_sse.service.CourseService;
import com.example.swp490_g25_sse.service.CustomUserDetailsService;
import com.example.swp490_g25_sse.service.LectureResultService;
import com.example.swp490_g25_sse.service.StudentCourseEnrollmentService;
import com.example.swp490_g25_sse.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentCourseEnrollmentService enrollService;

    @Autowired
    private LectureResultService lectureResultService;

    @Autowired
    private StudentCourseEnrollmentService studentCourseEnrollmentService;


    @GetMapping(value = "/{id}", produces = "application/json")
    public CourseDto getCourseById(@PathVariable long id) {
        Optional<Course> course = courseService.getCourseById(id);
        if (course.isEmpty()) {
            throw new BaseRestException(HttpStatus.NOT_FOUND, "Not Found");
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetailsService userDetails = (CustomUserDetailsService) auth.getPrincipal();

        Student student = studentService.getStudentInfo(userDetails.getUser());
        StudentCourseEnrollment enroll = studentCourseEnrollmentService.getEnrollmentInfo(student, course.get());

        CourseDto courseResult = new CourseDto();
        courseResult.setId(course.get().getId());
        courseResult.setContent(course.get().getContent());
        courseResult.setCourseImgUrl(course.get().getImageUrl());
        courseResult.setCourseTitle(course.get().getTitle());

        courseResult.setLectureDtos(
                course.get().getLectures().stream().map(item -> {
                    LectureDto lectureDto = new LectureDto();
                    lectureDto.setContent(item.getContent());
                    lectureDto.setId(item.getId());
                    lectureDto.setIndex(item.getIndexOrder());
                    lectureDto.setName(item.getName());
                    lectureDto.setResourceUrl(item.getResourceUrl());
                    lectureDto.setWeek(item.getWeek());

                    LectureResult lectureResult = lectureResultService.findFirstByEnrollmentAndLecture(enroll, item);

                    if (lectureResult == null) {
                        lectureDto.setIsFinished(false);
                    } else {

                        lectureDto.setIsFinished(lectureResult.getIsFinished());
                    }

                    return lectureDto;
                }).toList());

        return courseResult;
    }

    @GetMapping(produces = "application/json")
    public List<Course> queryCourses() {
        return courseService.getCourses();
    }
    //

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Course createCourse(@RequestBody CourseDto dto) {      
        Course course = courseService.createCourse(dto);

        return course;
    }

    //
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Course deleteCourse(@PathVariable long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetailsService currentUser = (CustomUserDetailsService) auth.getPrincipal();

        Optional<Course> course = courseService.getCourseById(id);

        if (course.isEmpty()) {
            throw new BaseRestException(HttpStatus.NOT_FOUND, "cant find this course to delete");
        }

        Teacher teacher = course.get().getTeacher();
        if (teacher.getUser().getId() != currentUser.getUser().getId()) {
            throw new BaseRestException(HttpStatus.FORBIDDEN, "you cant delete this course");
        }

        Optional<Course> result = courseService.deleteCourse(id);
        return result.get();
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public Course updateCourse(@PathVariable long id, @RequestBody CourseDto dto) throws JsonProcessingException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetailsService currentUser = (CustomUserDetailsService) auth.getPrincipal();

        Optional<Course> course = courseService.getCourseById(id);

        if (course.isEmpty()) {
            throw new BaseRestException(HttpStatus.NOT_FOUND, "cant find this course to edit");
        }

        Teacher teacher = course.get().getTeacher();

        if (teacher.getUser().getId() != currentUser.getUser().getId()) {
            throw new BaseRestException(HttpStatus.FORBIDDEN, "you cant edit this course");
        }

        Course result = courseService.updateCourse(dto, id);

        return result;
    }
}
