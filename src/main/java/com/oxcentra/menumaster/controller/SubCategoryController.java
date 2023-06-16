package com.oxcentra.menumaster.controller;

import com.oxcentra.menumaster.model.SubCategory;
import com.oxcentra.menumaster.services.SubCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/subcategories/{id}")
    @ResponseBody
    public List<SubCategory> getSubCategoriesByCategoryId(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return subCategoryService.getSubCategoriesByCategoryId(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/subcategory/{id}")
    @ResponseBody
    public Optional<SubCategory> getSubCategoryById(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return subCategoryService.getSubCategoryById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/subcategory")
    @ResponseBody
    public Boolean addSubCategory(@RequestBody SubCategory subCategory){
        log.info(subCategory.getName());
        return subCategoryService.addSubCategory(subCategory);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/subcategory/{id}")
    @ResponseBody
    public Boolean updateSubCategory(@RequestBody SubCategory subCategory){
        log.info(subCategory.getName());
        return subCategoryService.updateSubCategory(subCategory);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/subcategory/{id}")
    @ResponseBody
    public Boolean deleteSubCategory(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return subCategoryService.deleteSubCategory(id);
    }
}
