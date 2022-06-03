package com.sourabh.examportal.controller;


import com.sourabh.examportal.entity.exam.Question;
import com.sourabh.examportal.entity.exam.Quiz;
import com.sourabh.examportal.services.QuestionService;
import com.sourabh.examportal.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")

public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        System.out.println(question);
        System.out.println(question.getQuiz());
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //get all Question of any quiz
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable Long qid) {
//        Quiz quiz = new Quiz();
//        quiz.setQId(qid);
//        return ResponseEntity.ok(this.questionService.getQuestionOfQuiz(quiz));

        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
        List<Question> list = new ArrayList(questions);
        if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())) {
            list = list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }

        // we can implement new api method for user to hide answer by below method, if we hide here
        // then admin is not able to view correct answer
//        list.forEach((q)->{
//            q.setAnswer("");
//        });

        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    // get single question
    @GetMapping("/{quesId}")
    public Question getQuestion(@PathVariable Long quesId) {
        return this.questionService.getQuestion(quesId);
    }



    // delete quiz
    @DeleteMapping("/{quesid}")
    public void deleteQuestion(@PathVariable Long quesid) {
        this.questionService.deletQuestion(quesid);
    }

    // eval quiz
    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions) {
        double marksGot = 0;
        int correctAnswers = 0;
        int attempted = 0;
        for(Question q:questions) {
//            System.out.println(q.getGivenAnswer());
            Question question = this.questionService.get(q.getQuesId());

            if(question.getAnswer().equals(q.getGivenAnswer())) {
                correctAnswers++;
                double marksingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
                marksGot+=marksingle;
            }

            if( q.getGivenAnswer()!=null) {
                attempted++;
            }

        }

        Map<String,Object> map = Map.of("marksGot",marksGot,"correctAnswers",correctAnswers,"attempted",attempted);
        return ResponseEntity.ok(map);
    }
}
