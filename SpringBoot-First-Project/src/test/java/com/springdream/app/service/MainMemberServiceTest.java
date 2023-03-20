package com.springdream.app.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MainMemberServiceTest {

    @Autowired
    MainMemberService mainMemberService;

    @Test
    void checkId() {
        log.info("count : " + mainMemberService.checkId("rkdalsrn2331"));
    }
}