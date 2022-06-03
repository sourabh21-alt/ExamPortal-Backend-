package com.sourabh.examportal.entity.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long quesId;



    @Column(length=1000)
    private String content;
    private String image;

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private String answer;

    @Transient
    private String givenAnswer;

    @ManyToOne(fetch = FetchType.EAGER)

    private Quiz quiz;

    @Override
    public String toString() {
        return "Question{" +
                "quesId=" + quesId +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", answer='" + answer + '\'' +
                ", quiz=" + quiz +
                '}';
    }





}
