package com.oxcentra.menumaster.controller;

import com.oxcentra.menumaster.services.BusinessService;
import com.oxcentra.menumaster.services.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    Boolean verifyEmail(@RequestBody String value) {

        log.info(value);
        Integer code = Integer.parseInt(value);

        return businessService.verifyEmail(code);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/resend")
    public @ResponseBody
    Boolean resendEmployerVerificationCode() {

        return businessService.sendVerificationCode();
    }
}
