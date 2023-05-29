package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
    List<Menu> getMenusByBranchId(Integer id);
}
