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
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
     private EmailService emailService;

    List<Business> business=new ArrayList<>();

    private Business businessNew;
    private int verificationCode;

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
        String message;
        Boolean val;
        log.info("saved business: "+business.getName());
        //businessRepository.save(business);
        businessNew=business;
        if(sendVerificationCode().equals(true)) {

            message ="Verification code sent";
            val = true;
        }else{
            message =  " error";
            val = false;
        }

        log.info(message);
        return val;
    }

    @Override
    public Boolean sendVerificationCode(){
        log.info(businessNew.getEmail());
        Random random = new Random();
        verificationCode = random.nextInt(90000000) + 10000000;
        log.info(String.valueOf(verificationCode));
        String body="Verification code: "+verificationCode;
        String subject="Verification Code";
        log.info(body);
        

        if(emailService.sendEmail(businessNew.getEmail(),body,subject).equals(true)){
            log.info("verification code sent");
            return true;
        }else{
            return false;
        }

    }

    @Override
    public Optional<Business> getBusinessById(int id) {
        log.info("Get business by id: "+id);
        return businessRepository.findById(id);
    }

    @Override
    public Boolean updateBusinessById(Business business) {
        Optional<Business> business1=getBusinessById(business.getId());
        business.setBackground(business1.get().getBackground());
        business.setPassword(business1.get().getPassword());
        if(business.getLogo()==null){
            business.setLogo(business1.get().getLogo());
        }
        businessRepository.save(business);
        return true;
    }

    @Override
    public Boolean verifyEmail(Integer code) {
        log.info(String.valueOf(code));
        log.info(String.valueOf(verificationCode));
        if(code.equals(verificationCode)){
            log.info("saved");
            return saveBusiness();
        }else{
            log.info("didn't saved");
            return false;
        }
    }

    @Override
    public Boolean saveBusiness() {

        businessRepository.save(businessNew);
        log.info("saved "+businessNew.getName());
        return true;
    }
}
