package com.oxcentra.menumaster.repository;


import com.oxcentra.menumaster.model.Menus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenusRepository extends JpaRepository<Menus,Integer> {
}
