package com.sourabh.examportal.entity.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="category")
@Getter
@Setter
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Quiz>  quizzes = new LinkedHashSet<>();



    public Category() {
    }

    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }








}
