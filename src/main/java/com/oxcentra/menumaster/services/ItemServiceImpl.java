package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Items;
import com.oxcentra.menumaster.repository.ItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService{


    @Autowired
    private ItemsRepository itemsRepository;


    @Override
    public List<Items> getItemsByCategoryId(Integer id) {

        List<Items> items=new ArrayList<>();
        List<Items> allItems=new ArrayList<>();
        allItems=itemsRepository.findAll();

        items=allItems.stream().filter(i->id.equals(i.getCategory())).collect(Collectors.toList());

        log.info("item list "+items);
        return items;
    }

    @Override
    public List<Items> getItemsBySubCategoryId(Integer id) {
        List<Items> items=new ArrayList<>();
        List<Items> allItems=new ArrayList<>();
        allItems=itemsRepository.findAll();

        items=allItems.stream().filter(i->id.equals(i.getSubCategory())).collect(Collectors.toList());

        log.info("item list "+items);
        return items;
    }

    @Override
    public Boolean addItem(Items items) {
        log.info("Added new item");
        log.info("Sub Category id "+items.getSubCategory());

//if(items.getSubCategory()==0 || items.getSubCategory()==null){
//    ItemOfCategory items1=new ItemOfCategory();
//    items1.setName(items.getName());
//    items1.setCategory(items.getCategory());
//    items1.setPrice(items.getPrice());
//    items1.setBannerImg(items.getBannerImg());
//    items1.setDiscount(items.getDiscount());
//    itemsOfCategoryRepository.save(items1);
//}
        itemsRepository.save(items);
        return true;
    }

    @Override
    public Boolean updateItem(Items items) {
        log.info("Updated item");
        log.info("Sub Category id "+items.getSubCategory());
//        if(items.getSubCategory()==0 ||items.getSubCategory()==null){
//            ItemOfCategory items1=new ItemOfCategory();
//            items1.setId(items.getId());
//            items1.setName(items.getName());
//            items1.setCategory(items.getCategory());
//            items1.setPrice(items.getPrice());
//            items1.setBannerImg(items.getBannerImg());
//            items1.setDiscount(items.getDiscount());
//            itemsOfCategoryRepository.save(items1);
//        }
        itemsRepository.save(items);
        return true;
    }

    @Override
    public Boolean deleteItemById(Integer id) {
        log.info("Deleted item");
        itemsRepository.deleteById(id);
        return true;
    }
}
