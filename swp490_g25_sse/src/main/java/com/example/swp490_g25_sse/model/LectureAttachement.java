/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.model;

import org.springframework.stereotype.Component;

/**
 *
 * @author ADMIN
 */
@Component
public class LectureAttachement {
private int id;
private String attachUrl;

    public LectureAttachement() {
    }

    public LectureAttachement(int id, String imgUrl) {
        this.id = id;
        this.attachUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttachUrl() {
        return attachUrl;
    }

    public void setAttachUrl(String attachUrl) {
        this.attachUrl = attachUrl;
    }

}
