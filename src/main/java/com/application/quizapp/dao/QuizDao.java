package com.application.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer> {

    
} 