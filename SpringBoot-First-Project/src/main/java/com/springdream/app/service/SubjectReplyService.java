package com.springdream.app.service;

import com.springdream.app.domain.ReplyDTO;
import com.springdream.app.domain.ReplyVO;
import com.springdream.app.repository.ReplyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor @Qualifier("subject") @Primary
public class SubjectReplyService implements ReplyService {
    private final ReplyDAO replyDAO;

    @Override
    public void register(ReplyVO replyVO) {
        replyDAO.save(replyVO);
    }

    @Override
    public void modify(ReplyDTO replyDTO) {
        replyDAO.update(replyDTO);
    }

    @Override
    public void remove(Long replyNumber) {

    }

    @Override
    public ReplyDTO show(Long replyNumber) {
        return replyDAO.select(replyNumber);
    }

    @Override
    public List<ReplyDTO> showAll() {
        return null;
    }

    @Override
    public void adopt(ReplyDTO replyDTO) {

    }

    @Override
    public List<ReplyDTO> showMemberReplyAll(Long memberNumber) {
        return replyDAO.findMemberReplyAll(memberNumber);
    }
}
