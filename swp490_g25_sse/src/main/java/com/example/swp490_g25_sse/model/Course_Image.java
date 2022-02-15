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
@Table(name = "Course_image")
public class Course_Image {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long imageId;
    
    @Column(name = "imageUrl")
    private String imageUrl;
    
    @Column(name = "courseId")
    private long courseId;

    public Course_Image() {
    }

    public Course_Image(long imageId, String imageUrl, long courseId) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
        this.courseId = courseId;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
    
    
}
