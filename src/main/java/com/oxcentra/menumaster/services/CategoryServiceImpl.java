package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Category;
import com.oxcentra.menumaster.model.Items;
import com.oxcentra.menumaster.model.SubCategory;
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
    private SubCategoryService subCategoryService;

    @Autowired
    private ItemService itemService;

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
        List<SubCategory> subCategoryList=subCategoryService.getSubCategoriesByCategoryId(id);
        List<Items> itemsList=itemService.getItemsByCategoryId(id);
        if(subCategoryList.size()>0){
            Boolean result=subCategoryService.deleteSubCategoryByCategoryId(id);
            if(result){
                categoryRepository.deleteById(id);
            }
        }else if(itemsList.size()>0){
            Boolean result=itemService.deleteItemsByCategoryId(id);
            if(result){
                categoryRepository.deleteById(id);
            }
        }else{
            categoryRepository.deleteById(id);
        }

        return true;
    }

    @Override
    public Boolean deleteCategoryByMenyId(Integer id) {
        List<Category> categoryList=getCategoriesByMenuId(id);
        for(int i=0;i<categoryList.size();i++){
            deleteCategory(categoryList.get(i).getId());
        }
        return true;
    }
}
