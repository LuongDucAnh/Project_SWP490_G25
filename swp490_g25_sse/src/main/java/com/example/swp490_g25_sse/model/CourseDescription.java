/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.model;

import org.springframework.stereotype.Component;

/**
 *
 * @author ADMIN
 */
@Component
public class CourseDescription {

    private int desId;
    private String descripttion;
    private int courseId;

    public CourseDescription() {
    }

    public CourseDescription(int desId, String descripttion, int courseId) {
        this.desId = desId;
        this.descripttion = descripttion;
        this.courseId = courseId;
    }

    public int getDesId() {
        return desId;
    }

    public void setDesId(int desId) {
        this.desId = desId;
    }

    public String getDescripttion() {
        return descripttion;
    }

    public void setDescripttion(String descripttion) {
        this.descripttion = descripttion;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

}
