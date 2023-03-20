package com.springdream.app.service;

import com.springdream.app.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    void register() {
        MemberVO memberVO = new MemberVO();
        memberVO.create("anstjdwns1234", "1111", "msj1234@gmail.com",
                "문성준", "문성준321", "01011111111", "A", 1);
        for (int i = 0; i < 10; i++) {
            String memberId = "deleteTestId" + i;
            memberVO.setMemberId(memberId);
            memberService.register(memberVO);
        }
    }

    @Test
    void modify() {
        MemberVO memberVO = new MemberVO();
        memberVO.create("rkdalsrn1112", "1111", "msj1111@gmail.com",
                "문성준", "문성준123", "01011111111", "B", 1);

        int memberNumber = memberService.login(memberVO);
        if(memberNumber == 0){
            log.info("--------------로그인 실패--------------");
            return;
        } else{
            memberVO.setMemberNumber(memberNumber);
            memberVO.setMemberId("msj9999");
            memberVO.setMemberMobile("01022222222");
            memberService.modify(memberVO);
        }
    }

    @Test
    void quit() {
        memberService.quit(22L);
    }

    @Test
    void select() {
        memberService.select(25L);
    }

    @Test
    void selectAll() {
        memberService.selectAll().stream().map(MemberVO::getMemberId).forEach(log::info);
    }

    @Test
    void checkId() {
        log.info("checkId : " + memberService.checkId("kmg2331"));
    }

    @Test
    void login() {
        MemberVO memberVO = new MemberVO();
        memberVO.create("rkdalsrn1111", "1111", "msj1111@gmail.com",
                "문성준", "문성준123", "01011111111", "C", 1);
        log.info("memberId : " + memberService.login(memberVO));
    }
}