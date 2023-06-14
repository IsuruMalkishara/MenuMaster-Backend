package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getCategoriesByMenuId(Integer id);
}
