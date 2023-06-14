package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Category;
import com.oxcentra.menumaster.model.Menu;
import com.oxcentra.menumaster.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
                id.equals(m.getMenu().getId())).collect(Collectors.toList());

        return categoryList;
    }
}
