package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Categories;
import com.oxcentra.menumaster.model.Category;
import com.oxcentra.menumaster.model.Menu;
import com.oxcentra.menumaster.repository.CategoriesRepository;
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

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<Category> getCategoriesByMenuId(Integer id) {
        List<Category> categoryList=new ArrayList<>();
        categoryList=categoryRepository.findAll().stream().filter(m->
                id.equals(m.getMenu().getId())).collect(Collectors.toList());

        return categoryList;
    }

    @Override
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Boolean addCategories(Categories categories) {
        categoriesRepository.save(categories);
        return true;
    }

    @Override
    public Boolean updateCategory(Categories categories) {
        Optional<Categories> categories1=categoriesRepository.findById(categories.getId());
        categories.setMenu(categories1.get().getMenu());
        categoriesRepository.save(categories);
        return true;
    }

    @Override
    public Boolean deleteCategory(Integer id) {
        categoriesRepository.deleteById(id);
        return true;
    }
}
