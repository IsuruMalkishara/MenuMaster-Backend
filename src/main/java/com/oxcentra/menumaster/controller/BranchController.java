package com.oxcentra.menumaster.controller;

import com.oxcentra.menumaster.model.Branch;
import com.oxcentra.menumaster.model.Business;
import com.oxcentra.menumaster.services.BranchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class BranchController {
    @Autowired
    private BranchService branchService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/branches/{id}")
    @ResponseBody
    public List<Branch> getBranchByBusinessId(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return branchService.getBranchByBusinessId(id);
    }
}
