package com.application.quizapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor // gives default n parameterised constructor
public class ResponseWrapper {
    Integer Id;
    String answer;
}
