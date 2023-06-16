package com.oxcentra.menumaster.controller;

import com.oxcentra.menumaster.model.Item;
import com.oxcentra.menumaster.model.SubCategory;
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
    public List<Item> getItemsByCategoryId(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return itemService.getItemsByCategoryId(id);
    }
}
