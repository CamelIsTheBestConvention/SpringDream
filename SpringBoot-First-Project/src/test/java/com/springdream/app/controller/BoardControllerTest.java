package com.springdream.app.controller;

import com.springdream.app.service.SubjectBoardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BoardControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void main() throws Exception{
        log.info("boards: " + mockMvc.perform(MockMvcRequestBuilders.get("/board/boardMain")).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void write() throws Exception{
        log.info("flash map: " + mockMvc.perform(MockMvcRequestBuilders.post("/board/writePage")
                .param("boardCategory", "한국사")
            .param("boardTitle", "한국사 컨트롤러 테스트1")
            .param("boardContent", "한한")
            .param("boardReward", "400")
        .param("memberNumber", "23")).andReturn().getFlashMap());
    }

    @Test
    void read() throws Exception{
        log.info("model map" + mockMvc.perform(MockMvcRequestBuilders.get("/board/page").param("boardNumber", "11")).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void update() {

    }

    @Test
    void delete() {
    }
}