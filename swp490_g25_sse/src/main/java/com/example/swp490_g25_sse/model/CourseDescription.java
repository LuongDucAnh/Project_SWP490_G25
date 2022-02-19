/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Course_description")
public class CourseDescription {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long desId;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "courseId")
    private long courseId;

    public CourseDescription() {
    }

    public CourseDescription(long desId, String description, long courseId) {
        this.desId = desId;
        this.description = description;
        this.courseId = courseId;
    }

    public long getDesId() {
        return desId;
    }

    public void setDesId(long desId) {
        this.desId = desId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
    
    
}
