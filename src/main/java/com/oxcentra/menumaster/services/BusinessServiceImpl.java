package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Business;
import com.oxcentra.menumaster.repository.BusinessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    List<Business> business=new ArrayList<>();

    @Override
    public Business getUserByEmail(String email) {
        log.info(email);
        business=businessRepository.findAll().stream().filter(b->email.contains(b.getEmail())).collect(Collectors.toList());

        log.info(String.valueOf(business));
        return business.get(0);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        business=businessRepository.findAll().stream().filter(b->
                email.contains(b.getEmail())).collect(Collectors.toList());

        log.info(String.valueOf(business));

        if(business.size()>0){
            return new User(business.get(0).getEmail(),business.get(0).getPassword(),new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found");
        }


    }

    @Override
    public Boolean addNewBusiness(Business business) {
        log.info("saved business: "+business.getName());
        businessRepository.save(business);
        return true;
    }

    @Override
    public Optional<Business> getBusinessById(int id) {
        log.info("Get business by id: "+id);
        return businessRepository.findById(id);
    }
}
