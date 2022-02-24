/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.controller;

import com.example.swp490_g25_sse.model.CourseLecture;
import com.example.swp490_g25_sse.repository.LectureRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/lectures")
public class LectureController {
    
    @Autowired
    private LectureRepository lectureRepository;

    @GetMapping("")
    public List<CourseLecture> getAllCourseLectures() {
        return lectureRepository.findAll();
    }
}
