/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.controller;

import com.example.swp490_g25_sse.model.Course;
import com.example.swp490_g25_sse.model.CourseDescription;
import com.example.swp490_g25_sse.model.CourseImage;
import com.example.swp490_g25_sse.repository.CourseRepository;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class CourseController {

//    @Autowired
    private CourseRepository courseRepository;
   // private CourseService courseService;
//   @Autowired

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
        //this.courseService = courseService;
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
        course = c.get();
        model.addAttribute("course", course);
//        List<CourseImage> ci = courseService.findCourseImgById(courseId);
//        List<CourseDescription> cd = courseService.findCourseDesById(courseId);
        model.addAttribute("description", new CourseDescription());
        model.addAttribute("image", new CourseImage());
        return "updateCourse";
    }

    @PostMapping(value = {"/update/{courseId}"})
    public String read31(Model model, @PathVariable("courseId") Long courseId,
            @ModelAttribute("course") Course course,
            @ModelAttribute("image") CourseImage image,
            @ModelAttribute("description") CourseDescription description) {
        try {
            Course c = courseRepository.getById(courseId);
            CourseImage img = new CourseImage();
            CourseDescription des = new CourseDescription();
            Date date = new Date();
            c.setUserId(1);
            c.setUpdateDate(date);
            c.setCourseName(course.getCourseName());
            c.addDes(description);
            c.addImg(image);
            courseRepository.save(c);
            return "redirect:/display";
        } catch (Exception e) {
            e.printStackTrace();
            return "errorPage";
        }
    }

    @GetMapping(value = {"/delete/{courseId}"})
    public String deleteCourse(@PathVariable("courseId") Long courseId) {
        courseRepository.deleteById(courseId);
        return "redirect:/display";
    }

    @GetMapping(value = {"/courseCreate-menu"})
    public String read2(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("description", new CourseDescription());
        model.addAttribute("image", new CourseImage());
        return "fragments/courseCreate-menu";
    }

//    @GetMapping(value = {"/courseUpdate-menu"})
//    public String read5(Model model) {
//        model.addAttribute("course", new Course());
//        model.addAttribute("description", new CourseDescription());
//        model.addAttribute("image", new CourseImage());
//        return "fragments/courseUpdate-menu";
//    }
//    @GetMapping(value = {"/courseUpdate-menu"})
//    public String read4(Model model) {
//        model.addAttribute("course", new Course());
//        model.addAttribute("description", new CourseDescription());
//        model.addAttribute("image", new CourseImage());
//        return "fragments/courseUpdate-menu";
//    }
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
            course.setUserId(1);
            course.setCreateDate(date);
            course.setStartAt(date);
            course.setEndAt(date);
            //course.setDes(description);
            course.addDes(description);
            course.addImg(image);
            courseRepository.save(course);
            return "redirect:/display";
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
    //    @GetMapping(value = {"/courseUpdate-menu"})
//    public String read5(Model model) {
//        model.addAttribute("course", new Course());
//        model.addAttribute("description", new CourseDescription());
//        model.addAttribute("image", new CourseImage());
//        return "fragments/courseUpdate-menu";
//    }
//    @GetMapping(value = {"/courseUpdate-menu"})
//    public String read4(Model model) {
//        model.addAttribute("course", new Course());
//        model.addAttribute("description", new CourseDescription());
//        model.addAttribute("image", new CourseImage());
//        return "fragments/courseUpdate-menu";
//    }//    @GetMapping(value = {"/courseUpdate-menu"})
//    public String read5(Model model) {
//        model.addAttribute("course", new Course());
//        model.addAttribute("description", new CourseDescription());
//        model.addAttribute("image", new CourseImage());
//        return "fragments/courseUpdate-menu";
//    }
//    @GetMapping(value = {"/courseUpdate-menu"})
//    public String read4(Model model) {
//        model.addAttribute("course", new Course());
//        model.addAttribute("description", new CourseDescription());
//        model.addAttribute("image", new CourseImage());
//        return "fragments/courseUpdate-menu";
//    }//    @GetMapping(value = {"/courseUpdate-menu"})
//    public String read5(Model model) {
//        model.addAttribute("course", new Course());
//        model.addAttribute("description", new CourseDescription());
//        model.addAttribute("image", new CourseImage());
//        return "fragments/courseUpdate-menu";
//    }
//    @GetMapping(value = {"/courseUpdate-menu"})
//    public String read4(Model model) {
//        model.addAttribute("course", new Course());
//        model.addAttribute("description", new CourseDescription());
//        model.addAttribute("image", new CourseImage());
//        return "fragments/courseUpdate-menu";
//    }//    @GetMapping(value = {"/courseUpdate-menu"})
//    public String read5(Model model) {
//        model.addAttribute("course", new Course());
//        model.addAttribute("description", new CourseDescription());
//        model.addAttribute("image", new CourseImage());
//        return "fragments/courseUpdate-menu";
//    }
//    @GetMapping(value = {"/courseUpdate-menu"})
//    public String read4(Model model) {
//        model.addAttribute("course", new Course());
//        model.addAttribute("description", new CourseDescription());
//        model.addAttribute("image", new CourseImage());
//        return "fragments/courseUpdate-menu";
//    }
}
