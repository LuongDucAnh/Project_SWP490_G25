/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.controller;

import com.example.swp490_g25_sse.model.Answer;
import com.example.swp490_g25_sse.model.Course;
import com.example.swp490_g25_sse.model.Question;
import com.example.swp490_g25_sse.model.Student;
import com.example.swp490_g25_sse.repository.StudentRepository;
import com.example.swp490_g25_sse.service.AnswerService;
import com.example.swp490_g25_sse.service.CourseService;
import com.example.swp490_g25_sse.service.CustomUserDetailsService;
import com.example.swp490_g25_sse.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/app/student/forum")
public class ForumController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AnswerService answerService;

    @GetMapping("/{id}")
    private String index(Model model, @PathVariable String id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetailsService userDetails = (CustomUserDetailsService) auth.getPrincipal();

        List<Question> questions = questionService.getQuestionsByCourseId(Long.parseLong(id));

        Course course = courseService.getCourseById(Long.parseLong(id)).get();
        model.addAttribute("questions", questions);
        model.addAttribute("course", course);
        model.addAttribute("userName", userDetails.getUser().getFirstName());
        return "student/forum-questions";
    }
//
    
}
