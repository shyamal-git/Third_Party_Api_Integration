package com.sms.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String twilioPhoneNumber;

    public void sendSMS(String toPhoneNumber, String message) {
        Twilio.init(accountSid, authToken);

        // Use the Message creator to send an SMS
        Message sms = Message.creator(
                        new PhoneNumber(toPhoneNumber),  // To
                        new PhoneNumber(twilioPhoneNumber),  // From (your Twilio phone number)
                        message)
                .create();

        // Log or handle the response if needed
        System.out.println("SMS sent successfully. SID: " + sms.getSid());
    }
}

