package com.springdream.app.service;

import com.springdream.app.domain.BoardDTO;
import com.springdream.app.domain.BoardVO;
import com.springdream.app.domain.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    //    추가
    public void register(BoardVO boardVO);
    //    수정
    public void modify(BoardDTO boardDTO);
    //    삭제
    public void remove(Long boardNumber);
    //    조회
    public BoardDTO show(Long boardNumber);

    // 마이페이지 회원 게시글 전체 조회
    public List<BoardDTO> showMemberBoardAll(Long memberNumber);

    //    전체 조회
    public List<BoardDTO> showAll(Criteria criteria);
    //    인기글 조회
    public List<BoardDTO> popularPost();
    //    최신글 조회
    public List<BoardDTO> recentPost();
    //    카테고리별 조회
    public List<BoardDTO> categoryPost(String boardCategory);
}
