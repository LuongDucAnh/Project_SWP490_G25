/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.form;

import com.example.swp490_g25_sse.model.LectureAttachement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class LectureForm {
    private String lectureName;
    private int lectureWeek;
    private int courseId;
    private boolean markAsRead;
//    private List<LectureAttachement> lectureAttachements = new ArrayList<>();

    public LectureForm() {
    }

    
    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public int getLectureWeek() {
        return lectureWeek;
    }

    public void setLectureWeek(int lectureWeek) {
        this.lectureWeek = lectureWeek;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public boolean isMarkAsRead() {
        return markAsRead;
    }

    public void setMarkAsRead(boolean markAsRead) {
        this.markAsRead = markAsRead;
    }

//    public List<LectureAttachement> getLectureAttachements() {
//        return lectureAttachements;
//    }
//
//    public void setLectureAttachements(List<LectureAttachement> lectureAttachements) {
//        this.lectureAttachements = lectureAttachements;
//    }
    
    
}
