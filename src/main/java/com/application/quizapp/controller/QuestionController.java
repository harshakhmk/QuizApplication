package com.application.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.quizapp.model.Question;
import com.application.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("allQuestions/{topic}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String topic)
    {
        return questionService.getQuestionsByCategory(topic);
    }

    @PostMapping("allQuestions")
    // RequestBody will convert input json sent by client to mentioned Object(Question)
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }
    @PutMapping("allQuestions/{id}")
    // RequestBody will convert input json sent by client to mentioned Object(Question)
    public String updateQuestion(@RequestBody Question question,@PathVariable Integer id)
    {
        return questionService.updateQuestion(question,id);
    }
    @DeleteMapping("allQuestions/{id}")
    // RequestBody will convert input json sent by client to mentioned Object(Question)
    public String deleteQuestion(@PathVariable Integer id)
    {
        return questionService.deleteQuestion(id);
    }
    
}
