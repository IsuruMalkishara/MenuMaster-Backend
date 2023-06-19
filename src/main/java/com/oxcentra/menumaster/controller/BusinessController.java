package com.oxcentra.menumaster.controller;

import com.oxcentra.menumaster.common.JwtUtility;
import com.oxcentra.menumaster.dto.JwtRequestDto;
import com.oxcentra.menumaster.dto.JwtResponseDto;
import com.oxcentra.menumaster.model.Business;
import com.oxcentra.menumaster.services.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;


@Slf4j
@RestController
public class BusinessController {

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private BusinessService businessService;

    @Autowired
    private  AuthenticationManager authenticationManager;

    public BusinessController(JwtUtility jwtUtility, BusinessService businessService, AuthenticationManager authenticationManager){
        this.jwtUtility = jwtUtility;
        this.businessService=businessService;
        this.authenticationManager=authenticationManager;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    @ResponseBody
    public JwtResponseDto authentication(@RequestBody JwtRequestDto jwtRequest) throws Exception {

        log.info(jwtRequest.getEmail());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
        }catch (BadCredentialsException e){
            log.info("Error");
            throw new Exception("Invalid credential",e);

        }


        final Boolean result=true;
        final String message="SUCCESS";
        final String token=jwtUtility.generateToken(jwtRequest.getEmail());
        final Date expiresAt=jwtUtility.extractExpiration(token);
        final int expiresIn=jwtUtility.jwtExpirationInMs;

        log.info(token);

        JwtResponseDto jwtResponse=new JwtResponseDto();



        jwtResponse.setUser_id(businessService.getUserByEmail(jwtRequest.getEmail()).getId());
        jwtResponse.setResult(true);
        jwtResponse.setMessage("Success");
        jwtResponse.setAccess_token(jwtUtility.generateToken(jwtRequest.getEmail()));
        jwtResponse.setExpires_at(jwtUtility.extractExpiration(token));
        jwtResponse.setExpires_in(jwtUtility.jwtExpirationInMs);

        return jwtResponse;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signup")
    @ResponseBody
    public Boolean signup(@RequestBody Business business){
        log.info(business.getName());
        return businessService.addNewBusiness(business);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user/{id}")
    @ResponseBody
    public Optional<Business> getUserById(@PathVariable int id){
        log.info(String.valueOf(id));
        return businessService.getBusinessById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/user/{id}")
    @ResponseBody
    public Boolean updateUserById(@RequestBody Business business){
        log.info(business.getName());
        return businessService.updateBusinessById(business);
    }
}
