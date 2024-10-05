package com.application.quizapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class QuestionWrapper {
    @Id
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String diffcultylevel;
    private String category;

    public QuestionWrapper(Integer id, String questionTitle, String option1, String option2, String option3,String option3, String option4, String difficultyLevel, String category)
    {
        this.id=id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2=option2;
        this.option3 = option3;
        this.option4. = option4;
        this.diffcultylevel = difficultyLevel;
        this.category = category;
    }

}
