package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Branch;
import com.oxcentra.menumaster.model.Menu;
import com.oxcentra.menumaster.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
                id.equals(m.getBranch().getId())).collect(Collectors.toList());

        return menuList;
    }
}
