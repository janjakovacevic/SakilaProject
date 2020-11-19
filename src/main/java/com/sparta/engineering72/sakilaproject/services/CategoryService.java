package com.sparta.engineering72.sakilaproject.services;

import com.sparta.engineering72.sakilaproject.entities.Category;
import com.sparta.engineering72.sakilaproject.respositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return (List<Category>)categoryRepository.findAll();
    }

    public List<Category> getCategoryByCategoryName(String name){
        return categoryRepository.findCategoriesByName(name);
    }

    public Category getByCategoryId(Integer id){
        return categoryRepository.getCategoryByCategoryId(id);
    }

}
