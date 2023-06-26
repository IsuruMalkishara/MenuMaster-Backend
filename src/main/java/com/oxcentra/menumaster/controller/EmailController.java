package com.oxcentra.menumaster.controller;

import com.oxcentra.menumaster.dto.EmailDto;
import com.oxcentra.menumaster.dto.VerificationCodeDto;
import com.oxcentra.menumaster.services.BusinessService;
import com.oxcentra.menumaster.services.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;

@Slf4j
@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private BusinessService businessService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/verify")
    public @ResponseBody
    Boolean verifyEmail(@RequestBody VerificationCodeDto verificationCodeDto) {

        log.info(String.valueOf(verificationCodeDto.getCode()));
       // Integer code = Integer.parseInt(value);

        return businessService.verifyEmail(verificationCodeDto.getCode());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("password/verify")
    public @ResponseBody
    Boolean verifyEmailForResetPassowrd(@RequestBody VerificationCodeDto verificationCodeDto) {

        log.info(String.valueOf(verificationCodeDto.getCode()));
        // Integer code = Integer.parseInt(value);

        return businessService.verifyEmailForResetPassowrd(verificationCodeDto.getCode());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/resend")
    public @ResponseBody
    Boolean resendEmployerVerificationCode() {

        return businessService.sendVerificationCode();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/forgot")
    public @ResponseBody
    Boolean forgotPassword(@RequestBody EmailDto emailDto) {

        log.info(emailDto.getEmail());

            return businessService.resetPassowrd(emailDto.getEmail());

    }
}
