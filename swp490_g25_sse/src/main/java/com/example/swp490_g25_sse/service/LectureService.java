/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.service;

import com.example.swp490_g25_sse.model.CourseLecture;
import com.example.swp490_g25_sse.model.LectureAttachement;
import com.example.swp490_g25_sse.model.LectureContent;
import com.example.swp490_g25_sse.model.LectureImage;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class LectureService {

    public List<CourseLecture> display() {
        return List.of(new CourseLecture(1, "Bài học 1", 1,
                new LectureAttachement(1, "Chưa có"),
                new LectureContent(1, "Chưa có luôn"),
                new LectureImage(1, "Chưa có nữa"), 
                1)
        );
    }
}
