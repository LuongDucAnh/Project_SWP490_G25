/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.model;

import java.sql.Date;
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
@Table(name = "Course_rating")
public class Course_Rating {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ratingId;

    @Column(name = "ratingStar")
    private int ratingStar;

    @Column(name = "ratingText")
    private String ratingText;

    @Column(name = "courseId")
    private int courseId;
    
    @Column(name = "userId")
    private int userId;

    public Course_Rating() {
    }

    public Course_Rating(long ratingId, int ratingStar, String ratingText, int courseId, int userId) {
        this.ratingId = ratingId;
        this.ratingStar = ratingStar;
        this.ratingText = ratingText;
        this.courseId = courseId;
        this.userId = userId;
    }

    public long getRatingId() {
        return ratingId;
    }

    public void setRatingId(long ratingId) {
        this.ratingId = ratingId;
    }

    public int getRatingStar() {
        return ratingStar;
    }

    public void setRatingStar(int ratingStar) {
        this.ratingStar = ratingStar;
    }

    public String getRatingText() {
        return ratingText;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
    
}
