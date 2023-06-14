package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Menu;
import com.oxcentra.menumaster.model.SubCategory;
import com.oxcentra.menumaster.repository.SubCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SubCategoryServiceImpl implements SubCategoryService{
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<SubCategory> getSubCategoriesByCategoryId(Integer id) {
        log.info(String.valueOf(id));
        List<SubCategory> subCategoryList=new ArrayList<>();
        subCategoryList=subCategoryRepository.findAll().stream().filter(c->
                id.equals(c.getCategory().getId())).collect(Collectors.toList());

        return subCategoryList;
    }

    @Override
    public Optional<SubCategory> getSubCategoryById(Integer id) {
        log.info(String.valueOf(id));
        return subCategoryRepository.findById(id);
    }
}
