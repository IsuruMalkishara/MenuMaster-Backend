package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Branch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BranchService {
    List<Branch> getBranchByBusinessId(Integer id);
}
