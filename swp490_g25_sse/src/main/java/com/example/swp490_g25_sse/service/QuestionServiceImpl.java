/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.swp490_g25_sse.service;

import com.example.swp490_g25_sse.model.Answer;
import com.example.swp490_g25_sse.model.Question;
import com.example.swp490_g25_sse.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Iterable<Question> findAll() {

        return questionRepository.findAll();
    }

    @Override
    public int findAnswerIdCorrect(int questionId) {
        Question question = questionRepository.findById(questionId).get();
        for (Answer answer : question.getAnswers()) {
            if (answer.isCorrect()) {
                return answer.getAnswerId();
            }

        }
        return -1;
    }

}
