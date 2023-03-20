package com.springdream.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ReportControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void mainGetTest() {
    }

    @Test
    void mainPostTest() throws Exception{
        log.info("report post : " + mockMvc.perform(MockMvcRequestBuilders.post("/report")
        .param("reportTitle", "신고 테스트 제목5")
        .param("reportContent", "테스트 신고 내용 5")
        .param("reportType", "도배성 게시글")
        .param("memberNumber", "23")
        .param("boardNumber", "22")
        ).andReturn().getFlashMap());
    }
}