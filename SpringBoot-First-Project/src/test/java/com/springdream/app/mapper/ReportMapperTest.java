package com.springdream.app.mapper;

import com.springdream.app.domain.ReportVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ReportMapperTest {

    @Autowired
    private ReportMapper reportMapper;

    @Test
    void insert() {
        ReportVO reportVO = new ReportVO();
        reportVO.create("신고 테스트 제목2", "신고 테스트 내용2",
                "불건전하거나 불쾌감을 주는 내용", 1L, 22L);
        reportMapper.insert(reportVO);
    }

    @Test
    void select() {
        log.info("select : " + reportMapper.select(7L));
    }

    @Test
    void selectAll() {
        log.info("select : " + reportMapper.selectAll());
    }
}