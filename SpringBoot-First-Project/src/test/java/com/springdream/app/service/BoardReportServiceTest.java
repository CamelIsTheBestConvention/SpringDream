package com.springdream.app.service;

import com.springdream.app.domain.ReportVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BoardReportServiceTest {

    @Autowired @Qualifier("board")
    private ReportService reportService;

    @Test
    void register() {
        ReportVO reportVO = new ReportVO();
        reportVO.create("신고 테스트 제목4", "테스트 신고 내용 4", "도배성 게시글", 23L, 23L);
        reportService.register(reportVO);
    }

    @Test
    void show() {
        log.info("show : " + reportService.show(9L));
    }

    @Test
    void showAll() {
        log.info("show : " + reportService.showAll());
    }
}