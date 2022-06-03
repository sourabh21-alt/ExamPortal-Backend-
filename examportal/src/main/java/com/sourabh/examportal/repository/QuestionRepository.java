package com.sourabh.examportal.repository;

import com.sourabh.examportal.entity.exam.Question;
import com.sourabh.examportal.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
