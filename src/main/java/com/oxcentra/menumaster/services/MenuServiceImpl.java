package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Menu;
import com.oxcentra.menumaster.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuRepository menuRepository;


    @Override
    public List<Menu> getMenusByBranchId(Integer id) {
        List<Menu> menuList=new ArrayList<>();
        menuList=menuRepository.findAll().stream().filter(m->
                id.equals(m.getBranch())).collect(Collectors.toList());

        return menuList;
    }

    @Override
    public Optional<Menu> getMenusById(Integer id) {
        return menuRepository.findById(id);
    }

    @Override
    public Boolean addMenu(Menu menu) {
        menuRepository.save(menu);
        log.info("Added menu");
        return true;
    }

    @Override
    public Boolean updateMenu(Menu menu) {
        Optional<Menu> menus=menuRepository.findById(menu.getId());
        log.info(String.valueOf(menus));
        menu.setBranch(menu.getBranch());
        menuRepository.save(menu);
        log.info("Updated menu");
        return true;
    }

    @Override
    public Boolean deleteMenu(Integer id) {
        menuRepository.deleteById(id);
        return true;
    }
}
