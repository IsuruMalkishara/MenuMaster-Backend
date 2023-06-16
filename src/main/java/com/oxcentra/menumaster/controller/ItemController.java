package com.oxcentra.menumaster.controller;

import com.oxcentra.menumaster.model.Items;
import com.oxcentra.menumaster.services.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/category/{id}/item")
    @ResponseBody
    public List<Items> getItemsByCategoryId(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return itemService.getItemsByCategoryId(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/sub/{id}/item")
    @ResponseBody
    public List<Items> getItemsBySubCategoryId(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return itemService.getItemsBySubCategoryId(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/item")
    @ResponseBody
    public Boolean addItem(@RequestBody Items items){
        log.info(items.getName());
        return itemService.addItem(items);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/item/{id}")
    @ResponseBody
    public Boolean updateItem(@RequestBody Items items){
        log.info(items.getName());
        return itemService.updateItem(items);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/item/{id}")
    @ResponseBody
    public Boolean deleteItemById(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return itemService.deleteItemById(id);
    }
}
