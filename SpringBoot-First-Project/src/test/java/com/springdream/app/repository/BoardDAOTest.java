package com.springdream.app.repository;

import com.springdream.app.domain.BoardDTO;
import com.springdream.app.domain.BoardVO;
import com.springdream.app.domain.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardDAOTest {

    @Autowired
    private BoardDAO boardDAO;

    //    게시글 작성 테스트
    @Test
    public void saveTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.create("수학", "수학 다오 테스트1", "수학 매퍼 테스트 내용", 500, 256L);
        boardDAO.save(boardVO);
        boardVO.create("국어", "국어 다오 테스트1", "국어 매퍼 테스트 내용", 500, 257L);
        boardDAO.save(boardVO);
        boardVO.create("영어", "영어 다오 테스트1", "영어 매퍼 테스트 내용", 500, 258L);
        boardDAO.save(boardVO);
        boardVO.create("과탐", "과탐 다오 테스트1", "과탐 매퍼 테스트 내용", 500, 259L);
        boardDAO.save(boardVO);
    }

    //    게시글 수정 테스트
    @Test
    public void setBoardDTOTest(){
        BoardDTO boardDTO = boardDAO.findByBoard(1L);
        boardDTO.setBoardTitle("수정된 게시글 제목3");
        boardDAO.setBoardDTO(boardDTO);
    }

    //    게시글 조회 테스트
    @Test
    public void findByBoardTest(){
        log.info("board : " + boardDAO.findByBoard(1L));
    }

    //    게시글 목록 전체 조회
    @Test
    public void findAllTest(){
        Criteria criteria = new Criteria().create(1, 10);
        boardDAO.findAll(criteria).stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }

    //    신고 제외 전체 조회
    @Test
    public void findUnreportAllTest(){
        boardDAO.findUnreportAll().stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }

    //    인기글 조회
    @Test
    public void popularPost(){
        boardDAO.popularPost().stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }

    //    최신글 조회
    @Test
    public void recentPost(){
        boardDAO.recentPost().stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    };

    //    카테고리별 조회
    @Test
    public void categoryPost(){
        String category = "수학";
        boardDAO.categoryPost(category).stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }
}