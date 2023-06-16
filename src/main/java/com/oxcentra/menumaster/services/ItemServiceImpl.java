package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Item;
import com.oxcentra.menumaster.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getItemsByCategoryId(Integer id) {

        List<Item> items=new ArrayList<>();
        List<Item> allItems=new ArrayList<>();
        allItems=itemRepository.findAll();

        items=allItems.stream().filter(i->id.equals(i.getCategory().getId())).collect(Collectors.toList());

        log.info("item list "+items);
        return items;
    }
}
