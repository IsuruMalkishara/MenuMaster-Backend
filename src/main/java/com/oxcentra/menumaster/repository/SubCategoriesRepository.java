package com.oxcentra.menumaster.repository;

import com.oxcentra.menumaster.model.SubCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoriesRepository extends JpaRepository<SubCategories,Integer> {
}
