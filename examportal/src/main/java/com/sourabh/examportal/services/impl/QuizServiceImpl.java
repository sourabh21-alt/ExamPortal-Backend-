package com.sourabh.examportal.services.impl;

import com.sourabh.examportal.entity.exam.Category;
import com.sourabh.examportal.entity.exam.Quiz;
import com.sourabh.examportal.repository.QuizRepository;
import com.sourabh.examportal.services.QuestionService;
import com.sourabh.examportal.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public List<Quiz> getQizzesOfCategory(Category category) {
        return this.quizRepository.findByCategory(category);
    }

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getQuizzes() {
        return (List<Quiz>) this.quizRepository.findAll();
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {

        this.quizRepository.deleteById(quizId);
    }
}
