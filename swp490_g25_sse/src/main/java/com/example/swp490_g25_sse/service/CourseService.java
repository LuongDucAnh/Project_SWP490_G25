/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.service;

import com.example.swp490_g25_sse.model.CourseDescription;
import com.example.swp490_g25_sse.model.CourseImage;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CourseService {

    List<CourseImage> findCourseImgById(Long id);

    List<CourseDescription> findCourseDesById(Long id);
}
