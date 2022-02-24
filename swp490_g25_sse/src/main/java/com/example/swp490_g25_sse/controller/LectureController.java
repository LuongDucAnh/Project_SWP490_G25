/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.controller;

import com.example.swp490_g25_sse.exception.ResourceNotFoundException;
import com.example.swp490_g25_sse.model.CourseLecture;
import com.example.swp490_g25_sse.repository.LectureRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/{id}")
    public ResponseEntity<CourseLecture> getCourseLectureById(@PathVariable(value = "id") int CourseLectureId)
            throws ResourceNotFoundException, Exception {
        CourseLecture CourseLecture = lectureRepository.findById(CourseLectureId)
                .orElseThrow(() -> new Exception("CourseLecture not found for this id :: " + CourseLectureId));
        return ResponseEntity.ok().body(CourseLecture);
    }
}
