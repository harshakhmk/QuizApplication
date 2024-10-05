package com.application.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.application.quizapp.dao.QuestionDao;
import com.application.quizapp.model.Question;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }
    public ResponseEntity<List<Question>> getQuestionsByCategory(String topic) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(topic),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    public String updateQuestion(Question question, Integer id) {
        questionDao.save(question);
        return "Success";
    }
    public String deleteQuestion(Integer id) {
        questionDao.deleteById(id);
        return "successfully question deleted";
    }

}
