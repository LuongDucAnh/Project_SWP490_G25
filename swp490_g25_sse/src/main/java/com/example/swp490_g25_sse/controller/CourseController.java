/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.controller;

import com.example.swp490_g25_sse.model.Course;
import com.example.swp490_g25_sse.model.CourseDescription;
import com.example.swp490_g25_sse.model.CourseImage;
import com.example.swp490_g25_sse.repository.CourseRepository;
import com.example.swp490_g25_sse.repository.CourseRepositoryCustom;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class CourseController {

//    @Autowired
    private CourseRepository courseRepository;

//   @Autowired
    private CourseRepositoryCustom courseRepositoryCustom;

    @Autowired
    public CourseController(CourseRepository courseRepository, CourseRepositoryCustom courseRepositoryCustom) {
        this.courseRepository = courseRepository;
        this.courseRepositoryCustom = courseRepositoryCustom;
    }
    
    

//    @Autowired
//    CourseService courseService;
//    @Autowired
//    CourseImageRepository courseImgRepository;
//    @Autowired
//    CourseDescriptionRepository courseDesRepository;
    @GetMapping(value = {"/courseCreate"})
    public String read(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("description", new CourseDescription());
        model.addAttribute("image", new CourseImage());
        return "courseCreate";
    }

    @GetMapping(value = {"/courseCreate-menu"})
    public String html(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("description", new CourseDescription());
        model.addAttribute("image", new CourseImage());
        return "fragments/courseCreate-menu";
    }

    @PostMapping(value = {"/saveCourse"})
    private String saveCourse(@ModelAttribute("course") Course course,
            @ModelAttribute("description") CourseDescription description,
            @ModelAttribute("image") CourseImage image) {
        try {
            course.setCreateDate(LocalDate.now());
//            courseRepository.save(course);
            CourseImage cs = new CourseImage();
            cs.setCourseId(course);
            System.out.println(course.toString());
            return "redirect:/courseDisplay";
        } catch (Exception e) {
            e.printStackTrace();
            return "errorPage";
        }
    }

    @GetMapping(value = "/courseDisplay")
    private String showAllCourse(Model model) {
        model.addAttribute("course", courseRepository.findAll());
        return "Course_Display";
    }
}
