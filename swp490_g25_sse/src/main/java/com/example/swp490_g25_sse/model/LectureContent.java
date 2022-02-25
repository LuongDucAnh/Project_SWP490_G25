/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.model;

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
import org.springframework.stereotype.Component;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "Lecture_content")
public class LectureContent {

    private int contentId;
    private String contentText;
    @Autowired
    private List<LectureImage> lectureImages;

    public LectureContent() {
    }

    public LectureContent(int contentId, String contentText, List<LectureImage> lectureImages) {
        this.contentId = contentId;
        this.contentText = contentText;
        this.lectureImages = lectureImages;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    @Column(name = "contentText", nullable = false)
    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    @OneToMany(mappedBy = "lectureContent", cascade = CascadeType.PERSIST, orphanRemoval = true)
    public List<LectureImage> getLectureImages() {
        return lectureImages;
    }

    public void setLectureImages(List<LectureImage> lectureImages) {
        this.lectureImages = lectureImages;
    }

    public void addImage(LectureImage image) {
        image.setLectureContent(this);
        this.lectureImages.add(image);
    }
}
