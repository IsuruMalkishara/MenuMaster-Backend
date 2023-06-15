package com.oxcentra.menumaster.controller;

import com.oxcentra.menumaster.model.Categories;
import com.oxcentra.menumaster.model.Category;
import com.oxcentra.menumaster.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/categories/{id}")
    @ResponseBody
    public List<Category> getCategoriesByMenuId(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return categoryService.getCategoriesByMenuId(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/category/{id}")
    @ResponseBody
    public Optional<Category> getCategoryById(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return categoryService.getCategoryById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/category")
    @ResponseBody
    public Boolean addCategory(@RequestBody Categories categories){
        log.info(categories.getName());
        return categoryService.addCategories(categories);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/category/{id}")
    @ResponseBody
    public Boolean updateCategory(@RequestBody Categories categories){
        log.info(categories.getName());
        return categoryService.updateCategory(categories);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/category/{id}")
    @ResponseBody
    public Boolean deleteCategory(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return categoryService.deleteCategory(id);
    }
}
