package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Items;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<Items> getItemsByCategoryId(Integer id);

    List<Items> getItemsBySubCategoryId(Integer id);

    Boolean addItem(Items items);

    Boolean updateItem(Items items);

    Boolean deleteItemById(Integer id);
}
