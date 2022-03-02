/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.service;

import com.example.swp490_g25_sse.model.CourseDescription;
import com.example.swp490_g25_sse.model.CourseImage;
import com.example.swp490_g25_sse.repository.CourseDescriptionRepository;
import com.example.swp490_g25_sse.repository.CourseImageRepository;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Admin
 */
public class CourseServiceImpl implements CourseService {

    private CourseDescriptionRepository cdr;
    private CourseImageRepository cir;
    private EntityManager em;

    @Autowired
    public CourseServiceImpl(CourseDescriptionRepository cdr, CourseImageRepository cir, EntityManager em) {
        this.cdr = cdr;
        this.cir = cir;
        this.em = em;
    }

    @Override
    public Optional<CourseImage> findCourseImgById(Long id) {
        try {
            String sql = "select * from Course_image"
                    + "where courseId = ?";
            Query query = em.createQuery(sql);
            return (Optional) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Optional<CourseDescription> findCourseDesById(Long id) {
        try {
            String sql = "select * from Course_description"
                    + "where courseId = ?";
            Query query = em.createQuery(sql);
            return (Optional) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
