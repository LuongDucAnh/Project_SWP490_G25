/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.controller;

import com.example.swp490_g25_sse.model.Course;
import com.example.swp490_g25_sse.model.CourseDescription;
import com.example.swp490_g25_sse.model.CourseImage;
import com.example.swp490_g25_sse.repository.CourseDescriptionRepository;
import com.example.swp490_g25_sse.repository.CourseImageRepository;
import com.example.swp490_g25_sse.repository.CourseRepository;
import com.example.swp490_g25_sse.repository.CourseRepositoryCustom;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/course")
public class CourseController {

//    @Autowired
    private CourseRepository courseRepository;
    private CourseRepositoryCustom courseRepositoryCustom;
    private CourseImageRepository courseImgRepo;
    private CourseDescriptionRepository courseDesRepo;
//   @Autowired

    @Autowired
    public CourseController(CourseRepository courseRepository, CourseRepositoryCustom courseRepositoryCustom, CourseImageRepository courseImgRepo, CourseDescriptionRepository courseDesRepo) {
        this.courseRepository = courseRepository;
        this.courseRepositoryCustom = courseRepositoryCustom;
        this.courseImgRepo = courseImgRepo;
        this.courseDesRepo = courseDesRepo;
    }

    @GetMapping(value = {"/add"})
    public String read(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("description", new CourseDescription());
        model.addAttribute("image", new CourseImage());
        return "courseCreate";
    }

    @GetMapping(value = {"/courseCreate-menu"})
    public String read2(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("description", new CourseDescription());
        model.addAttribute("image", new CourseImage());
        return "fragments/courseCreate-menu";
    }

    @GetMapping(value = "/display")
    private String showAllCourse(Model model) {
        model.addAttribute("course", courseRepository.findAll());
        return "Course_Display";
    }
//    @GetMapping(value = {"/courseCreate-menu"})
//    public String html(Model model) {
//        model.addAttribute("course", new Course());
//        model.addAttribute("description", new CourseDescription());
//        model.addAttribute("image", new CourseImage());
//        return "fragments/courseCreate-menu";
//    }

    @PostMapping(value = {"/add"})
    private String saveCourse(@ModelAttribute("course") Course course,
            @ModelAttribute("image") CourseImage image,
            @ModelAttribute("description") CourseDescription description) {
        try {
            Date date = new Date();
            course.setCreateDate(date);
            course.setStartAt(date);
            course.setEndAt(date);
            course.addDes(description);
            course.addImg(image);
            courseRepository.save(course);
            return "redirect:/course/display";
        } catch (Exception e) {
            e.printStackTrace();
            return "errorPage";
        }
    }

}
