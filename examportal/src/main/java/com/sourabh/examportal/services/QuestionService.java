package com.sourabh.examportal.services;

import com.sourabh.examportal.entity.exam.Question;
import com.sourabh.examportal.entity.exam.Quiz;

import java.util.Set;

public interface QuestionService {

     public Question addQuestion(Question question);
     public Question updateQuestion (Question question);
     public Set<Question> getQuestion();
     public Question getQuestion(Long questionId);
     public Set<Question> getQuestionOfQuiz(Quiz quiz);

     public void deletQuestion(Long questionId);

     public Question get(Long questionId);
}
