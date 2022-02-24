/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "Lecture_image")
public class LectureImage {

    private int imageId;
    private String imageUrl;
    private CourseLecture courseLecture;
    private LectureContent lectureContent;

    public LectureImage() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Column(name = "imageUrl", nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lectureId")
    public CourseLecture getCourseLecture() {
        return courseLecture;
    }

    public void setCourseLecture(CourseLecture courseLecture) {
        this.courseLecture = courseLecture;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contentId")
    public LectureContent getLectureContent() {
        return lectureContent;
    }

    public void setLectureContent(LectureContent lectureContent) {
        this.lectureContent = lectureContent;
    }
}
