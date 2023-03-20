package com.springdream.app.mapper;

import com.springdream.app.domain.BoardDTO;
import com.springdream.app.domain.BoardVO;
import com.springdream.app.domain.ReplyDTO;
import com.springdream.app.domain.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class ReplyMapperTest {
    @Autowired
    private ReplyMapper replyMapper;

    @Test
    public void insertTest() {
        ReplyVO replyVO = new ReplyVO();
        replyVO.create("답글 매퍼 테스트1", "답글 테스트중 ", 25L, 25L);
        replyMapper.insert(replyVO);
    }

    @Test
    public void updateTest(){
        ReplyDTO replyDTO = replyMapper.select(1L);
        replyDTO.setReplyTitle("답글 매퍼 업데이트 테스트");
        replyMapper.update(replyDTO);
    }

    @Test
    public void delete() {
    }

    @Test
    public void select() {
    }
}