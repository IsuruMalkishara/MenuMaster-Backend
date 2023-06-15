package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Menu;
import com.oxcentra.menumaster.model.Menus;
import com.oxcentra.menumaster.repository.MenuRepository;
import com.oxcentra.menumaster.repository.MenusRepository;
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

    @Autowired
    private MenusRepository menusRepository;

    @Override
    public List<Menu> getMenusByBranchId(Integer id) {
        List<Menu> menuList=new ArrayList<>();
        menuList=menuRepository.findAll().stream().filter(m->
                id.equals(m.getBranch().getId())).collect(Collectors.toList());

        return menuList;
    }

    @Override
    public Optional<Menu> getMenusById(Integer id) {
        return menuRepository.findById(id);
    }

    @Override
    public Boolean addMenu(Menus menu) {
        menusRepository.save(menu);
        log.info("Added menu");
        return true;
    }

    @Override
    public Boolean updateMenu(Menus menu) {
        Optional<Menus> menus=menusRepository.findById(menu.getId());
        log.info(String.valueOf(menus));
        menu.setBranch(menus.get().getBranch());
        menusRepository.save(menu);
        log.info("Updated menu");
        return true;
    }

    @Override
    public Boolean deleteMenu(Integer id) {
        menuRepository.deleteById(id);
        return true;
    }
}
