/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.controller;

import com.example.swp490_g25_sse.model.Course;
import com.example.swp490_g25_sse.repository.CourseRepository;
import com.example.swp490_g25_sse.repository.CourseRepositoryCustom;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/showAllCourse")
    public String showAllCourse(Model model) {
        List<Course> course = courseRepository.findAll();
        model.addAttribute("course", course);
        return "Course_Display";
    }
}
