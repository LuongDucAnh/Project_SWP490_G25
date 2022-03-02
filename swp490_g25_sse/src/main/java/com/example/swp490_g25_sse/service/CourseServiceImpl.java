/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.service;

import com.example.swp490_g25_sse.dto.CourseDTO;
import com.example.swp490_g25_sse.model.CourseDescription;
import com.example.swp490_g25_sse.model.CourseImage;
import com.example.swp490_g25_sse.repository.CourseDescriptionRepository;
import com.example.swp490_g25_sse.repository.CourseImageRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
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

    @Override
    public CourseDTO getCourseDetailsById(Long id) {
         try {
            String sql = "select c.courseId, courseName, imageId, imageUrl, desId, content "
                    + " from Course c"
                    + " inner join CourseImage i"
                    + " on c.courseId = i.courseId"
                    + " inner join CourseDescription d"
                    + " where i.courseId = d.courseId"
                    + " where c.courseId = " +id;
            Query query = em.createQuery(sql);
            return (CourseDTO) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
