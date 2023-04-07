package com.springdream.app.controller;

import com.springdream.app.domain.BoardDTO;
import com.springdream.app.domain.ReplyDTO;
import com.springdream.app.domain.ReplyVO;
import com.springdream.app.service.BoardReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
    private final BoardReplyService boardReplyService;


    //    추가
    @PostMapping("/new")
    public String write(@RequestBody ReplyVO replyVO){
        boardReplyService.save(replyVO);
        return "write success";
    }

    // 댓글 전체 조회
    @GetMapping("/{boardNumber}")
    public List<ReplyDTO> list(@PathVariable("boardNumber") Long boardNumber){
        return boardReplyService.showAll(boardNumber);
    }

//    수정

//    삭제
    @DeleteMapping("/{replyNumber}")
    public String remove(@PathVariable("replyNumber") Long replyNumber){
        boardReplyService.remove(replyNumber);
        return "delete success";
    }


}
