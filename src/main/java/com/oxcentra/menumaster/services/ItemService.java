package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<Item> getItemsByCategoryId(Integer id);
}
