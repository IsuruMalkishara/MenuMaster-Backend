package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Branch;
import com.oxcentra.menumaster.repository.BranchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BranchServiceImpl implements BranchService{
    @Autowired
    private BranchRepository branchRepository;

    @Override
    public List<Branch> getBranchByBusinessId(Integer id) {
        List<Branch> branchList=new ArrayList<>();
        branchList=branchRepository.findAll().stream().filter(b->
               id.equals(b.getBusiness().getId())).collect(Collectors.toList());

        return branchList;
    }
}
