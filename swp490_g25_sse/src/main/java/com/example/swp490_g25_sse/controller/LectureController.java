/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.controller;

import javax.validation.Valid;

import com.example.swp490_g25_sse.exception.ResourceNotFoundException;
import com.example.swp490_g25_sse.model.CourseLecture;
import com.example.swp490_g25_sse.model.LectureAttachement;
import com.example.swp490_g25_sse.model.LectureContent;
import com.example.swp490_g25_sse.model.LectureImage;
import com.example.swp490_g25_sse.repository.LectureRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping("/lecture")
public class LectureController {

    @GetMapping("/add")
    public String index(Model model) {
        model.addAttribute("lecture", new CourseLecture());
        return "createlecture";
    }
    
    @Autowired
    private LectureRepository lectureRepository;

    @GetMapping("/show")
    public String showList(Model model) {
        model.addAttribute("lectures", lectureRepository.findAll());
        return "showlecture";
    }

    @GetMapping("/{id}")
    public String getCourseLectureById(@PathVariable(value = "id") int CourseLectureId, Model model)
            throws ResourceNotFoundException, Exception {
        CourseLecture courseLecture = new CourseLecture();
        courseLecture = lectureRepository.findById(CourseLectureId)
                .orElseThrow(() -> new Exception("CourseLecture not found for this id :: " + CourseLectureId));
        model.addAttribute("lecture", courseLecture);
        return "updatelecture";
    }

    @PostMapping("/add")
    public String createCourseLecture(@ModelAttribute("lectureForm") CourseLecture CourseLecture) {
        LectureAttachement attachement = new LectureAttachement();
        attachement.setAttachUrl("okeokeoke");
//Add Image
        LectureImage lectureImage = new LectureImage();
        lectureImage.setImageUrl("URL new image");
//Add lecture
        LectureContent lectureContent = new LectureContent();
        lectureContent.setContentText("This is the new content");
        lectureContent.addImage(lectureImage);
//Add image and lecture to course
        CourseLecture.addAttachement(attachement);
        CourseLecture.addContent(lectureContent);
        CourseLecture.addImage(lectureImage);
        lectureRepository.save(CourseLecture);
        return "Ok";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CourseLecture> updateCourseLecture(@PathVariable(value = "id") int CourseLectureId,
            @Valid @RequestBody CourseLecture CourseLectureDetails) throws ResourceNotFoundException {
        CourseLecture CourseLecture = lectureRepository.findById(CourseLectureId)
                .orElseThrow(() -> new ResourceNotFoundException("CourseLecture not found for this id :: " + CourseLectureId));

        CourseLecture.setLectureName(CourseLectureDetails.getLectureName());
        CourseLecture.setLectureWeek(CourseLectureDetails.getLectureWeek());
        CourseLecture.setCourseId(CourseLectureDetails.getCourseId());
        CourseLecture.setMarkAsRead(CourseLectureDetails.isMarkAsRead());

        for (LectureContent content : CourseLecture.getLectureContents()) {
            if (content.getContentId() == 2) {
                content.setContentText("Chưa cập nhật thành công");
            }
        }
        for (LectureImage image : CourseLecture.getLectureImages()) {
            if (image.getImageId() == 1) {
                image.setImageUrl("Chưa cập nhật thành công");
            }
        }
        for (LectureAttachement attachement : CourseLecture.getLectureAttachements()) {
            if (attachement.getAttachId() == 24) {
                attachement.setAttachUrl("Chưa cập nhật thành công");
            }
        }

        final CourseLecture updatedCourseLecture = lectureRepository.save(CourseLecture);
        return ResponseEntity.ok(updatedCourseLecture);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteCourseLecture(@PathVariable(value = "id") int CourseLectureId)
            throws ResourceNotFoundException {
        CourseLecture CourseLecture = lectureRepository.findById(CourseLectureId)
                .orElseThrow(() -> new ResourceNotFoundException("CourseLecture not found for this id :: " + CourseLectureId));

        lectureRepository.delete(CourseLecture);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
