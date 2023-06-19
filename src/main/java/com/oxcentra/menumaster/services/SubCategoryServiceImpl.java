package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Items;
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

    @Autowired
    private ItemService itemService;

    @Override
    public List<SubCategory> getSubCategoriesByCategoryId(Integer id) {
        log.info(String.valueOf(id));
        List<SubCategory> subCategoryList=new ArrayList<>();
        subCategoryList=subCategoryRepository.findAll().stream().filter(c->
                id.equals(c.getCategory())).collect(Collectors.toList());

        return subCategoryList;
    }

    @Override
    public Optional<SubCategory> getSubCategoryById(Integer id) {
        log.info(String.valueOf(id));
        return subCategoryRepository.findById(id);
    }

    @Override
    public Boolean addSubCategory(SubCategory subCategory) {
        log.info(subCategory.getName());
        subCategoryRepository.save(subCategory);
        return true;
    }

    @Override
    public Boolean updateSubCategory(SubCategory subCategory) {
        Optional<SubCategory> subCategories1=subCategoryRepository.findById(subCategory.getId());
        subCategory.setCategory(subCategories1.get().getCategory());
        subCategoryRepository.save(subCategory);
        return true;
    }

    @Override
    public Boolean deleteSubCategory(Integer id) {
        List<Items> itemsList=itemService.getItemsBySubCategoryId(id);
        if(itemsList.size()>0){
            Boolean result=itemService.deleteItemsBySubCategoryId(id);
            if(result){
                subCategoryRepository.deleteById(id);
            }
        }else{
            subCategoryRepository.deleteById(id);
        }

        return true;
    }

    @Override
    public Boolean deleteSubCategoryByCategoryId(Integer id) {
        List<SubCategory> subCategoryList=getSubCategoriesByCategoryId(id);
        for(int i=0;i<subCategoryList.size();i++){
            deleteSubCategory(subCategoryList.get(i).getId());
        }
        return true;
    }
}
