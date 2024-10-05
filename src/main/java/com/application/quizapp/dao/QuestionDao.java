package com.application.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.quizapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question>findByCategory(String topic);

    // JPL Query to get executed when this function is called
    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQuestions ",nativeQuery = true)
    List<Question> getRandomQuestionsByCategory(String category, Integer numQuestions);

    
} 
