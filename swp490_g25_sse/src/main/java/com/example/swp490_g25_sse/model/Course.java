/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseId")
    private long courseId;

    @Column(name = "courseName")
    private String courseName;

    @Column(name = "createDate")
    private LocalDate createDate;

    @Column(name = "updateDate")
    private LocalDate updateDate;

    @Column(name = "userId")
    private long userId;

    public Course() {
    }

    public Course(long courseId, String courseName, LocalDate createDate, LocalDate updateDate, long userId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.userId = userId;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

//    @Override
//    public String toString() {
//        return "Course{" + "courseId=" + courseId + ", courseName=" + courseName + ", ratingId=" + ratingId + ", createDate=" + createDate + '}';
//    }
}
