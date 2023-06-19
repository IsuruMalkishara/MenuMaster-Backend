package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Branch;
import com.oxcentra.menumaster.model.Menu;
import com.oxcentra.menumaster.repository.BranchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BranchServiceImpl implements BranchService{
    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private MenuService menuService;

    @Override
    public List<Branch> getBranchByBusinessId(Integer id) {
        List<Branch> branchList=new ArrayList<>();
        branchList=branchRepository.findAll().stream().filter(b->
               id.equals(b.getBusiness())).collect(Collectors.toList());

        return branchList;
    }

    @Override
    public Optional<Branch> getBranchById(Integer id) {
        return branchRepository.findById(id);
    }

    @Override
    public Boolean addBranch(Branch branch) {
        log.info(String.valueOf(branch.getId()));
        log.info(String.valueOf(branch));
        branchRepository.save(branch);
        return true;
    }

    @Override
    public Boolean updateBranch(Branch branch) {
        Optional<Branch> branch1;
        branch1=branchRepository.findById(branch.getId());
        branch.setBackground(branch1.get().getBackground());
        branch.setBusiness(branch1.get().getBusiness());
        branch.setStatus(branch1.get().getStatus());
        branch.setQrcode(branch1.get().getQrcode());
        log.info(String.valueOf(branch));
        branchRepository.save(branch);
        return true;
    }

    @Override
    public Boolean deleteBranch(Integer id) {
        log.info("Delete branch id "+id);
        List<Menu> menuList=menuService.getMenusByBranchId(id);

        if(menuList.size()>0){
            Boolean result=menuService.deleteMenuByBranchId(id);
            if(result){
                branchRepository.deleteById(id);
            }
        }else{
            branchRepository.deleteById(id);
        }


        return true;
    }
}
