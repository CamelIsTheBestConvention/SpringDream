/*
* redis 설치 후 서버를 실행해야 가능
*
* */
package com.springdream.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class CoolSmsService {

    private static final String COOLSMS_API_KEY = "Your_Key";
    private static final String COOLSMS_API_SECRET = "Your_Secret";
    private static final String COOLSMS_SENDER = "Sender_Phonenumber";
    Message coolsms = new Message(COOLSMS_API_KEY, COOLSMS_API_SECRET);


    public String sendAuthNumber(String phoneNumber) {
        // 6자리 인증번호 생성
        String authNumber = String.format("%06d", (int) (Math.random() * 1000000));

        // Redis에 인증번호 저장
//        redisTemplate.opsForValue().set(phoneNumber, authNumber);


        // SMS 메시지 발송
        String message = "본인인증 인증번호는 [" + authNumber + "]입니다.";
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phoneNumber);
        params.put("from", COOLSMS_SENDER);
        params.put("type", "SMS");
        params.put("text", message);
        params.put("app_version", "test app 1.2");

        try {
            // send() 메소드를 사용하여 문자메시지 전송
            HashMap<String, String> result = coolsms.send(params);
            System.out.println(result.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }

        return authNumber;
    }

    public boolean verifyAuthNumber(String authNumber, String verifyNumber) {
        // 인증번호 비교
        return authNumber.equals(verifyNumber);
    }
}