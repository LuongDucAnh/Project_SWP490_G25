/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "Course_lecture")
public class CourseLecture {

    private int lectureId;
    private String lectureName;
    private int lectureWeek;
    private int courseId;
    private boolean markAsRead;
    private List<LectureAttachement> lectureAttachements = new ArrayList<>();
    private List<LectureImage> lectureImages = new ArrayList<>();
    private List<LectureContent> lectureContents = new ArrayList<>();

    public CourseLecture() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    @Column(name = "lectureName", nullable = false)
    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    @Column(name = "lectureWeek", nullable = false)
    public int getLectureWeek() {
        return lectureWeek;
    }

    public void setLectureWeek(int lectureWeek) {
        this.lectureWeek = lectureWeek;
    }

    @Column(name = "courseId", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Column(name = "markAsRead", nullable = false)
    public boolean isMarkAsRead() {
        return markAsRead;
    }

    public void setMarkAsRead(boolean markAsRead) {
        this.markAsRead = markAsRead;
    }

    @OneToMany(mappedBy = "courseLecture", cascade = CascadeType.PERSIST, orphanRemoval = true)
    public List<LectureAttachement> getLectureAttachements() {
        return lectureAttachements;
    }

    public void setLectureAttachements(List<LectureAttachement> lectureAttachements) {
        this.lectureAttachements = lectureAttachements;
    }

    @OneToMany(mappedBy = "courseLecture", cascade = CascadeType.PERSIST, orphanRemoval = true)
    public List<LectureImage> getLectureImages() {
        return lectureImages;
    }

    public void setLectureImages(List<LectureImage> lectureImages) {
        this.lectureImages = lectureImages;
    }

    @OneToMany(mappedBy = "courseLecture", cascade = CascadeType.PERSIST, orphanRemoval = true)
    public List<LectureContent> getLectureContents() {
        return lectureContents;
    }

    public void setLectureContents(List<LectureContent> lectureContents) {
        this.lectureContents = lectureContents;
    }

    public void addAttachement(LectureAttachement attachement) {
        attachement.setCourseLecture(this);
        this.lectureAttachements.add(attachement);
    }

    public void addImage(LectureImage image) {
        image.setCourseLecture(this);
        this.lectureImages.add(image);
    }
    
        public void addContent(LectureContent content) {
        content.setCourseLecture(this);
        this.lectureContents.add(content);
    }

}
