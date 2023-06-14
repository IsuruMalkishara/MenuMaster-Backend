package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Branch;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BranchService {
    List<Branch> getBranchByBusinessId(Integer id);

    Optional<Branch> getBranchById(Integer id);

    Boolean addBranch(Branch branch);

    Boolean updateBranch(Branch branch);

    Boolean deleteBranch(Integer id);
}
