package com.oxcentra.menumaster.controller;

import com.oxcentra.menumaster.model.Category;
import com.oxcentra.menumaster.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
