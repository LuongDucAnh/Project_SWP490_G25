/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.controller;

import com.example.swp490_g25_sse.model.Course;
import com.example.swp490_g25_sse.model.Course_Description;
import com.example.swp490_g25_sse.model.Course_Image;
import com.example.swp490_g25_sse.repository.CourseRepository;
import com.example.swp490_g25_sse.repository.CourseRepositoryCustom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Admin
 */
@Controller
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseRepositoryCustom courseRepositoryCustom;

    @RequestMapping(value = {"/insertCourse"}, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        Course courseAdd = new Course();
        model.addAttribute("courseAdd", courseAdd);

        return "courseCreate";
    }

    @RequestMapping(value = {"/insertCourse"}, method = RequestMethod.POST)
    private String createCourse(Model model, @ModelAttribute("courseAdd") Course course) {
        try {
            Course_Description cd;
            Course_Image ci;
            String courseName = course.getCourseName();
            if (courseName != null && courseName.length() > 0) {
                long courseId = courseRepositoryCustom.getMaxId() + 1;
                Course newCourse = new Course(courseId, courseName, 0, LocalDateTime.now());
                courseRepository.save(newCourse);
            }
            return "redirect:/showAllCourse";
        } catch (Exception e) {
            e.printStackTrace();
            return "errorPage";
        }

    }

    @GetMapping("/showAllCourse")
    private String showAllCourse(Model model) {
        List<Course> course = courseRepository.findAll();
        model.addAttribute("course", course);
        return "Course_Display";
    }
}
