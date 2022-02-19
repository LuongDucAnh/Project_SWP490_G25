/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.model;

import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author ADMIN
 */
@Component
public class Course {
    private int courseId;
    private String courseName;
    private Date createDate;
    private Date updateDate;
    private int userId;

    public Course() {
    }

    public Course(int courseId, String courseName, Date createDate, Date updateDate, int userId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
