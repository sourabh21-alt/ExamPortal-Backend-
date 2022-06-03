package com.sourabh.examportal.repository;

import com.sourabh.examportal.entity.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
