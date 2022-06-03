package com.sourabh.examportal.controller;

import com.sourabh.examportal.entity.exam.Category;
import com.sourabh.examportal.entity.exam.Quiz;
import com.sourabh.examportal.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // add quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz) {

        System.out.println(quiz.getCategory().getId());
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //update Quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //get all Quiz
    @GetMapping("/")
    public ResponseEntity<?> getQuizzes() {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    // get single quiz
    @GetMapping("/{qid}")
    public Quiz getQuiz(@PathVariable Long qid) {
        return this.quizService.getQuiz(qid);
    }

    // delete quiz
    @DeleteMapping("/{qid}")
    public void deleteQuiz(@PathVariable Long qid) {
        this.quizService.deleteQuiz(qid);
    }

    @GetMapping("/category/{cid}")
    public List<Quiz> getQuizzesOfCategory(@PathVariable Long cid) {
        Category category = new Category();
        category.setId(cid);
        return this.quizService.getQizzesOfCategory(category);
    }

}
