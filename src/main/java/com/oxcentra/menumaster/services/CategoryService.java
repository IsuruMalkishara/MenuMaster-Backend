package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    List<Category> getCategoriesByMenuId(Integer id);

    Optional<Category> getCategoryById(Integer id);

    Boolean addCategories(Category categories);

    Boolean updateCategory(Category categories);

    Boolean deleteCategory(Integer id);

    Boolean deleteCategoryByMenyId(Integer id);
}
