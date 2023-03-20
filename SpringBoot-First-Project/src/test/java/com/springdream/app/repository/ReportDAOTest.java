package com.springdream.app.repository;

import com.springdream.app.domain.ReportVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ReportDAOTest {

    @Autowired
    private ReportDAO reportDAO;

    @Test
    void register() {
        ReportVO reportVO = new ReportVO();
        reportVO.create("신고 테스트 제목3", "불건전한 게시글입니다. 테스트용.",
                "불건전하거나 불쾌감을 주는 내용", 23L, 23L);
        reportDAO.register(reportVO);
    }

    @Test
    void select() {
        log.info("select : " + reportDAO.select(8L));
    }

    @Test
    void selectAll() {
        log.info("selectAll : " + reportDAO.selectAll());
    }
}