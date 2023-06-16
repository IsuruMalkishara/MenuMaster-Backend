package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Category;
import com.oxcentra.menumaster.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getCategoriesByMenuId(Integer id) {
        List<Category> categoryList=new ArrayList<>();
        categoryList=categoryRepository.findAll().stream().filter(m->
                id.equals(m.getMenu())).collect(Collectors.toList());

        return categoryList;
    }

    @Override
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Boolean addCategories(Category category) {
        categoryRepository.save(category);
        return true;
    }

    @Override
    public Boolean updateCategory(Category category) {
        Optional<Category> categories1=categoryRepository.findById(category.getId());
        category.setMenu(categories1.get().getMenu());
        categoryRepository.save(category);
        return true;
    }

    @Override
    public Boolean deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
        return true;
    }
}
