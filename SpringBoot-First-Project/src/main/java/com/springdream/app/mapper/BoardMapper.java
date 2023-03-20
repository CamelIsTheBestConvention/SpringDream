package com.springdream.app.mapper;

import com.springdream.app.domain.BoardDTO;
import com.springdream.app.domain.BoardVO;
import com.springdream.app.domain.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //    추가
    public void insert(BoardVO boardVO);
    //    수정
    public void update(BoardDTO boardDTO);
    //    조회수 증가
    public void addViewCount(Long boardNumber);
    //    삭제
    public void delete(Long boardNumber);
    //    조회
    public BoardDTO select(Long boardNumber);

    // 회원 게시글 전체 조회
    public List<BoardDTO> selectMemberAll(Long memberNumber);

    //    신고 제외한 전체 조회
    public List<BoardDTO> selectUnreportAll();

    //    전체 조회
    public List<BoardDTO> selectAll(Criteria criteria);

    //게시글 전체 갯수 조회
    public int countTotal();

    //    인기글 조회
    public List<BoardDTO> popularBoard();

    //    최신글 조회
    public List<BoardDTO> recentBoard();

    //    카테고리별 조회
    public List<BoardDTO> categoryBoard(String boardCategory);

    //    검색
    public List<BoardDTO> selectByKeywordAll(String keyword);
}
