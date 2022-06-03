package com.sourabh.examportal.services;

import com.sourabh.examportal.entity.exam.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Category getCategory(Long categoryId);
    public void deleteCategory(Long categoryId);
    public List<Category> getCategories() ;
}
