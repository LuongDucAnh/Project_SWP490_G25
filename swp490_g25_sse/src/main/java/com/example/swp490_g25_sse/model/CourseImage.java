/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Course_image")
public class CourseImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imageId")
    private long imageId;

    @Column(name = "desId")
    private long desId;

    @Column(name = "imageUrl")
    private String imageUrl;
    
    @OneToOne(mappedBy = "Course")
    private Course course;

    public CourseImage() {
    }

//    public CourseImage(long imageId, long desId, String imageUrl) {
//        this.imageId = imageId;
//        this.desId = desId;
//        this.imageUrl = imageUrl;
//    }
    
//    public CourseImage(long imageId, long desId, String imageUrl, Course course) {
//        this.imageId = imageId;
//        this.desId = desId;
//        this.imageUrl = imageUrl;
//        this.course = course;
//    }

//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }

    public long getDesId() {
        return desId;
    }

    public void setDesId(long desId) {
        this.desId = desId;
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

}
