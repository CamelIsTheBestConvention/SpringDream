/*
* redis 설치 후 서버를 실행해야 가능
*
* */
package com.springdream.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Service
public class RedisCoolSmsService {

    private static final String COOLSMS_API_KEY = "NCS17TNMMUIV2SIM";
    private static final String COOLSMS_API_SECRET = "VVJDSWDO7NARFFY1TAUXDCRMX2I7QW5T";
    private static final String COOLSMS_SENDER = "SpringDream";

    private final StringRedisTemplate redisTemplate;
    private final RestTemplate restTemplate;

    public RedisCoolSmsService(StringRedisTemplate redisTemplate, RestTemplate restTemplate) {
        this.redisTemplate = redisTemplate;
        this.restTemplate = restTemplate;
    }

    public void sendAuthNumber(String phoneNumber) {
        // 6자리 인증번호 생성
        String authNumber = String.format("%06d", (int) (Math.random() * 1000000));

        // Redis에 인증번호 저장
        redisTemplate.opsForValue().set(phoneNumber, authNumber);

        // SMS 메시지 발송
        String message = "본인인증 인증번호는 [" + authNumber + "]입니다.";
        String url = "https://api.coolsms.co.kr/sms/2.0/send";
        String payload = String.format("{'type':'SMS','to':'%s','from':'%s','text':'%s'}",
                phoneNumber, COOLSMS_SENDER, message);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Basic " + Base64.getEncoder().encodeToString(
                (COOLSMS_API_KEY + ":" + COOLSMS_API_SECRET).getBytes()));
        HttpEntity<String> request = new HttpEntity<>(payload, headers);
        restTemplate.postForEntity(url, request, String.class);
    }

    public boolean verifyAuthNumber(String phoneNumber, String authNumber) {
        // Redis에서 인증번호 검색
        String storedAuthNumber = redisTemplate.opsForValue().get(phoneNumber);

        // 인증번호 비교
        return authNumber.equals(storedAuthNumber);
    }
}