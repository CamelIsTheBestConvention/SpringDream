package com.springdream.app.mapper;


import com.springdream.app.domain.BoardDTO;
import com.springdream.app.domain.BoardVO;
import com.springdream.app.domain.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;


    //    게시글 작성 테스트
    @Test
    public void insertTest() {
        BoardVO boardVO = new BoardVO();
        boardVO.create("한국사", "한국사 매퍼 테스트1", "한국사 매퍼 테스트 내용", 200, 225L);
        boardMapper.insert(boardVO);
    }

    //    게시글 수정 테스트
    @Test
    public void updateTest() {
        BoardDTO boardDTO = boardMapper.select(81L);
        boardDTO.setBoardTitle("보드 매퍼테스트");
        boardMapper.update(boardDTO);
    }

    @Test
    void selectMemberAllTest() {
        log.info("selectMemberAll : " + boardMapper.selectMemberAll(23L));
    }

    //    게시글 조회 테스트
    @Test
    public void selectTest() {
        log.info("board : " + boardMapper.select(1L));
    }

    //    게시글 목록 전체 조회
    @Test
    public void selectAllTest() {
        Criteria criteria = new Criteria().create(1, 10);
        boardMapper.selectAll(criteria).stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }

    //    신고 안된사람 조회
    @Test
    public void selectUnreportAllTest() {
        boardMapper.selectUnreportAll().stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }

    //    인기글 조회
    @Test
    public void popularBoard() {
        boardMapper.popularBoard().stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }

    //    최신글 조회
    @Test
    public void recentBoard() {
        boardMapper.recentBoard().stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }

    ;

    //    카테고리별 조회
//    국어
    @Test
    public void categoryBoard() {
        boardMapper.categoryBoard("국어").stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }

    @Test
    public void selectByKeywordAll() {
        boardMapper.selectByKeywordAll("테스트").stream().map(BoardDTO::getBoardTitle).forEach(log::info);
    }
}

