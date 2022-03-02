/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.dto;

/**
 *
 * @author Admin
 */
public class CourseDTO {
    
    private String courseId;
    private String courseName;
    private String courseImage;
    private String courseDescription;

    public CourseDTO() {
    }

    public CourseDTO(String courseId, String courseName, String courseImage, String courseDescription) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseImage = courseImage;
        this.courseDescription = courseDescription;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }


    
    
}
