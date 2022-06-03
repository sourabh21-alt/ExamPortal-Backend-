package com.sourabh.examportal.services.impl;

import com.sourabh.examportal.entity.exam.Category;
import com.sourabh.examportal.repository.CategoryRepository;
import com.sourabh.examportal.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public Category getCategory(Long categoryId) {
        return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        this.categoryRepository.deleteById(categoryId);

    }

    @Override
    public List<Category> getCategories() {
        return (List<Category>) this.categoryRepository.findAll();
    }
}
