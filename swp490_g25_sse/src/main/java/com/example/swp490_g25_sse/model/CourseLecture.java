/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ADMIN
 */
@Component
public class CourseLecture {

    private int lectureId;
    private String lectureName;
    private int lectureWeek;
    @Autowired
    private LectureAttachement lectureAttach;
    @Autowired
    private LectureContent lectureContent;
    @Autowired
    private LectureImage lectureImage;
    private int courseId;

    public CourseLecture() {
    }

    public CourseLecture(int lectureId, String lectureName, int lectureWeek, LectureAttachement lectureAttach, LectureContent lectureContent, LectureImage lectureImage, int courseId) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.lectureWeek = lectureWeek;
        this.lectureAttach = lectureAttach;
        this.lectureContent = lectureContent;
        this.lectureImage = lectureImage;
        this.courseId = courseId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
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

    public LectureAttachement getLectureAttach() {
        return lectureAttach;
    }

    public void setLectureAttach(LectureAttachement lectureAttach) {
        this.lectureAttach = lectureAttach;
    }

    public LectureContent getLectureContent() {
        return lectureContent;
    }

    public void setLectureContent(LectureContent lectureContent) {
        this.lectureContent = lectureContent;
    }

    public LectureImage getLectureImage() {
        return lectureImage;
    }

    public void setLectureImage(LectureImage lectureImage) {
        this.lectureImage = lectureImage;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
