package com.springdream.app.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class PointMapperTest {

    @Autowired
    private PointMapper pointMapper;

    @Test
    void insert() {
    }

    @Test
    void addPoint() {
        pointMapper.addPoint(500L, 112L);
    }
}