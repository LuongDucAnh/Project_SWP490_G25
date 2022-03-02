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
import com.example.swp490_g25_sse.service.CourseService;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    private CourseService cs;
//   @Autowired

    @Autowired
    public CourseController(CourseRepository courseRepository, CourseRepositoryCustom courseRepositoryCustom, CourseImageRepository courseImgRepo, CourseDescriptionRepository courseDesRepo, CourseService cs) {
        this.courseRepository = courseRepository;
        this.courseRepositoryCustom = courseRepositoryCustom;
        this.courseImgRepo = courseImgRepo;
        this.courseDesRepo = courseDesRepo;
        this.cs = cs;
    }

    @GetMapping(value = {"/add"})
    public String read(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("description", new CourseDescription());
        model.addAttribute("image", new CourseImage());
        return "courseCreate";
    }

    @GetMapping(value = {"/update/{courseId}"})
    public String read3(Model model, @PathVariable("courseId") Long courseId) {
        Optional<Course> c = courseRepository.findById(courseId);
        Course course = null;
        CourseDescription cd = null;
        CourseImage ci = null;
        course = c.get();
        model.addAttribute("course", course);
        Optional<CourseDescription> d = cs.findCourseDesById(courseId);
        cd = d.get();
        model.addAttribute("description", cd);
        Optional<CourseImage> i = cs.findCourseImgById(courseId);
        ci = i.get();
        model.addAttribute("image", ci);
//        model.addAttribute("course", new Course());
        //model.addAttribute("course", new Course());
//        model.addAttribute("course1", courseRepository.getById(courseId));
//        model.addAttribute("description", courseDesRepo.findAll());
//        model.addAttribute("image", courseImgRepo.findAll());
        return "updateCourse";
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

//    @PutMapping(value = {"/update/{courseId}"})
//    private String updateCourse(@PathVariable("courseId") Long courseId) {
//        try {
//            Course course = courseRepository.findById(courseId);
//
//            return "redirect:/course/display";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "errorPage";
//        }
//    }
}
