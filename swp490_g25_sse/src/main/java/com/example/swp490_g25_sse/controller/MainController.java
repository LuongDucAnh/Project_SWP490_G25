/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class MainController {

    @GetMapping("/listCourse")
    private String listCourseController() {
        return "listCourse";
    }

    @GetMapping("/login")
    private String loginController() {
        return "login";
    }

    @GetMapping("/listmenu")
    private String listCourseMenu() {
        return "fragments/listcourse-menu";
    }
}
