package com.springdream.app.service;

import com.springdream.app.domain.ReplyDTO;
import com.springdream.app.domain.ReplyVO;
import com.springdream.app.repository.ReplyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardReplyService {
    private final ReplyDAO replyDAO;

//    댓글 추가
    public void save(ReplyVO replyVO){
        replyDAO.save(replyVO);
    }

//    해당 게시글 댓글 조회
    public List<ReplyDTO> showAll(Long boardNumber){
        return replyDAO.findAll(boardNumber);
    }

}
