package com.springdream.app.repository;

import com.springdream.app.domain.BoardDTO;
import com.springdream.app.domain.BoardVO;
import com.springdream.app.domain.Criteria;
import com.springdream.app.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;
    //    추가
    public void save(BoardVO boardVO){
        boardMapper.insert(boardVO);
    }
    //    수정
    public void setBoardDTO(BoardDTO boardDTO){
        boardMapper.update(boardDTO);
    }
    //    삭제
    public void remove(Long boardNumber){
        boardMapper.delete(boardNumber);
    }
    //    조회
    public BoardDTO findByBoard(Long boardNumber){
        return boardMapper.select(boardNumber);
    }

    //    조회수 증가
    public void addViewCount(Long boardNumber) { boardMapper.addViewCount(boardNumber); }

    // 회원 게시글 전체 조회
    public List<BoardDTO> findMemberBoardAll(Long memberNumber){
        return boardMapper.selectMemberAll(memberNumber);}

    //    전체 조회
    public List<BoardDTO> findAll(Criteria criteria){
        return boardMapper.selectAll(criteria);
    }

    //게시글 전체 갯수 조회
    public int countTotal() { return boardMapper.countTotal(); };

    //    신고되지 않은 게시물 조회
    public List<BoardDTO> findUnreportAll(){
        return boardMapper.selectUnreportAll();
    }

    //    인기글 조회
    public List<BoardDTO> popularPost(){
        return boardMapper.popularBoard();
    }

    //    최신글 조회
    public List<BoardDTO> recentPost(){
        return boardMapper.recentBoard();
    }

    //    카테고리별 조회
    public List<BoardDTO> categoryPost(String boardCategory){ return boardMapper.categoryBoard(boardCategory); }

    public List<BoardDTO> searchByKeywordAll(String keyword) {
        return boardMapper.selectByKeywordAll(keyword);
    }
}
