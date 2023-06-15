package com.oxcentra.menumaster.controller;

import com.oxcentra.menumaster.model.Menu;
import com.oxcentra.menumaster.model.Menus;
import com.oxcentra.menumaster.services.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/menu/{id}")
    @ResponseBody
    public Optional<Menu> getMenusById(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return menuService.getMenusById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/menu")
    @ResponseBody
    public Boolean addMenu(@RequestBody Menus menu){
        log.info(menu.getName());
        return menuService.addMenu(menu);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/menu/{id}")
    @ResponseBody
    public Boolean updateMenu(@RequestBody Menus menu){
        log.info(menu.getName());
        return menuService.updateMenu(menu);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/menu/{id}")
    @ResponseBody
    public Boolean deleteMenu(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return menuService.deleteMenu(id);
    }

}
