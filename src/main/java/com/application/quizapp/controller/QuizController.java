package com.application.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.quizapp.service.QuizService;
import com.application.quizapp.model.QuestionWrapper;
import com.application.quizapp.model.ResponseWrapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("")
    public ResponseEntity<String> addQuiz(@RequestParam String category, @RequestParam Integer NumQuestions,@RequestParam String title )
    {
        return quizService.createQuiz(category,NumQuestions,title);
    }
    @GetMapping("quizinfo/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@RequestParam Integer id) {
        return quizService.getQuizQuestions(id);
    }
    @PostMapping("quizinfo/{id}")
    public ResponseEntity<Integer> submitquiz(@PathVariable Integer id, @RequestBody List<ResponseWrapper> responses ) {
        return quizService.submitquiz(id,responses);
    }
    
    


}
