package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Menu;
import com.oxcentra.menumaster.model.Menus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MenuService {
    List<Menu> getMenusByBranchId(Integer id);

    Optional<Menu> getMenusById(Integer id);

    Boolean addMenu(Menus menu);

    Boolean updateMenu(Menus menu);

    Boolean deleteMenu(Integer id);
}
