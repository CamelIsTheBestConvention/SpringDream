package com.springdream.app.repository;

import com.springdream.app.domain.Criteria;
import com.springdream.app.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class MemberDAOTest {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void getBoardNumTest() {
        log.info("boardNum : " + memberDAO.getBoardNum(1L));
    }

    @Test
    public void selectRecentTest() {
        log.info("select recent : " + memberDAO.selectRecent(20));
    }

    @Test
    public void selectAllTest(){
        log.info("select all : " + memberDAO.selectAll(new Criteria().create(1, 10)));
    }

    @Test
    public void joinTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.create("ljs2345", "1234", "lsj1234@gmail.com", "이준상", "LJS19931", "01012342345", "D", 1);
        memberDAO.join(memberVO);
    }

    @Test
    public void loginTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberId("msj4264");
        memberVO.setMemberPw("11112");
        log.info("login : " + memberDAO.login(memberVO));
    }
}