package com.application.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestParam;

import com.application.quizapp.dao.QuestionDao;
import com.application.quizapp.dao.QuizDao;
import com.application.quizapp.model.Question;
import com.application.quizapp.model.QuestionWrapper;
import com.application.quizapp.model.Quiz;
import com.application.quizapp.model.ResponseWrapper;

@Service
public class QuizService {
    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, Integer NumQuestions,String title)
    {
        List<Question> questions = questionDao.getRandomQuestionsByCategory(category,NumQuestions);
        Quiz  quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Quiz created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        
        Optional<Quiz>quiz = quizDao.findById(id);
        List<Question>questions = quiz.get().getQuestions();
        List<QuestionWrapper>questionWrappers = new ArrayList<>();
        for(Question q:questions)
        {
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption3(),q.getOption4(),q.getDiffcultylevel(),q.getCategory());
            questionWrappers.add(qw);
        }
        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitquiz(Integer id, List<ResponseWrapper> responses) {
        Integer correctAnswers=0;
        for(ResponseWrapper response:responses)
        {
            String user_answer = response.getAnswer();
            String actual_answer = questionDao.findById(response.getId()).get().getRightAnswer();
            if( user_answer == actual_answer)
            {
                correctAnswers = correctAnswers+1;
            }
        }
        return new ResponseEntity<>(correctAnswers,HttpStatus.OK);

    }
}
