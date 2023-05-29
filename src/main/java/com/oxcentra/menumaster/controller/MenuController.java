package com.oxcentra.menumaster.controller;

import com.oxcentra.menumaster.model.Branch;
import com.oxcentra.menumaster.model.Menu;
import com.oxcentra.menumaster.services.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/menus/{id}")
    @ResponseBody
    public List<Menu> getMenusByBranchId(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return menuService.getMenusByBranchId(id);
    }

}
