package com.springdream.app.service;

import com.springdream.app.domain.Criteria;
import com.springdream.app.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AdminMemberServiceTest {

    @Autowired
    private AdminMemberService adminMemberService;

    @Test
    void register() {

    }

    @Test
    void modify() {
    }

    @Test
    void quit() {
    }

    @Test
    void select() {
        log.info(" select : " + adminMemberService.select(1L));
    }

    @Test
    public void newMembersTest(){
        log.info("new members : " + adminMemberService.newMembers(20));
    }

    @Test
    void selectAllTest() {
        log.info(" selectAll : " + adminMemberService.selectAll());
    }

    @Test
    void sselectAllDTOTest() {
        log.info(" selectAll DTO : " + adminMemberService.selectAllDTO(new Criteria().create(1, 10)));
    }

    @Test
    void boardCountTest(){
        log.info(" boardCount : " + adminMemberService.boardCount(1L));
    }

    @Test
    void checkId() {
    }

    @Test
    void login() {
    }
}