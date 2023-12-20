package com.otpverification.service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OTPService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String phoneNumber;

    public String generateOTP() {
        // Generate a 6-digit OTP
        int otp = new java.util.Random().nextInt(900000) + 100000;
        return String.valueOf(otp);
    }

    public void sendOTP(String to, String otp) {
        Twilio.init(accountSid, authToken);

        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(to),
                        new com.twilio.type.PhoneNumber(phoneNumber),
                        "Your OTP is: " + otp)
                .create();

        System.out.println("OTP sent with SID: " + message.getSid());
    }
}

