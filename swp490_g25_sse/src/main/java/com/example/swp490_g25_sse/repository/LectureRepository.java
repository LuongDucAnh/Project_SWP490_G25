/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.repository;

import com.example.swp490_g25_sse.model.Lecture;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author msi
 */
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    public List<Lecture> findAll();

    public List<Lecture> findAll(Sort sort);

    public void flush();

    public <S extends Lecture> S saveAndFlush(S entity);

    public void deleteAllInBatch(Iterable<Lecture> entities);

}
