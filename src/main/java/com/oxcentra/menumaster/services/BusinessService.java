package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.model.Business;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface BusinessService extends UserDetailsService {
    Business getUserByEmail(String email);

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

    Boolean addNewBusiness(Business business);

    Optional<Business> getBusinessById(int id);
}
