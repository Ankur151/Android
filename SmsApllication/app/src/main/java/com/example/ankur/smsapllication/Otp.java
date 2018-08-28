package com.example.ankur.smsapllication;

import java.util.Random;

public class Otp {
    String[] OTP={
            "1234",
            "4567",
            "7890",
            "0123",
            "3456",
            "6789"

    };
    String getOTP(){
        Random randomOTP=new Random();
        int randomOTPgenerator=randomOTP.nextInt(OTP.length);
        return OTP[randomOTPgenerator];
    }

}
