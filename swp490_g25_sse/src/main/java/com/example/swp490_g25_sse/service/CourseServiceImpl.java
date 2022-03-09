/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.service;

import com.example.swp490_g25_sse.model.CourseDescription;
import com.example.swp490_g25_sse.model.CourseImage;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Admin
 */
public class CourseServiceImpl implements CourseService {

    private EntityManager em;

    @Autowired
    public CourseServiceImpl(EntityManager em) {

        this.em = em;
    }

    @Override
    public List<CourseImage> findCourseImgById(Long id) {
        try {
            String sql = "select imageId, imageUrl from CourseImage"
                    + " where courseId = " + id;
            Query query = em.createQuery(sql);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<CourseDescription> findCourseDesById(Long id) {
        try {
            String sql = "select desId,content from CourseDescription"
                    + " where courseId = " + id;
            Query query = em.createQuery(sql);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
