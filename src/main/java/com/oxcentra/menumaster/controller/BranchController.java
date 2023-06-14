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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/branch/{id}")
    @ResponseBody
    public Optional<Branch> getBranchById(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return branchService.getBranchById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/branch")
    @ResponseBody
    public Boolean addBranch(@RequestBody Branch branch){
        log.info(String.valueOf(branch));
        return branchService.addBranch(branch);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/branch/{id}")
    @ResponseBody
    public Boolean updateBranch(@RequestBody Branch branch){
        log.info(String.valueOf(branch));
        return branchService.updateBranch(branch);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/branch/{id}")
    @ResponseBody
    public Boolean deleteBranch(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return branchService.deleteBranch(id);
    }


}
