package com.otpverification.controller;

import com.otpverification.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OTPController {

    @Autowired
    private OTPService otpService;

    @PostMapping("/api/otp/generate")
    public String generateOTP(@RequestParam String phoneNumber) {
        // Generate OTP
        String otp = otpService.generateOTP();

        // Send OTP via Twilio
        otpService.sendOTP(phoneNumber, otp);

        return "OTP generated and sent successfully.";
    }

    @PostMapping("/api/otp/verify")
    public String verifyOTP(@RequestParam String phoneNumber, @RequestParam String userEnteredOTP) {
        // Implement OTP verification logic
        // For simplicity, let's assume the OTP is correct
        return "OTP verified successfully.";
    }
}

