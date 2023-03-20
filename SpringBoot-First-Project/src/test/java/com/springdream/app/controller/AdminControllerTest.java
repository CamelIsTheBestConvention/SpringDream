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
class AdminControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

//  브라우저 URL 환경
    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void main() {
    }

    @Test
    void userList() {
    }

    @Test
    void support() {
    }

    @Test
    void boards() throws Exception{
//      URL 전송, Map 형태로 받음
        log.info( "boards : " +
            mockMvc.perform(MockMvcRequestBuilders.
                    get("/admin/boards")).andReturn().getModelAndView().getModelMap()
        );
    }

    @Test
    void report() {
    }
}